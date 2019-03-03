package lesson22.spring.mvc.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.sql.DataSource;
import javax.ws.rs.core.Response.Status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lesson16.entry.Orders;
import lesson22.spring.mvc.config.MainMvcConfig;
import lesson22.spring.mvc.dto.ErrorMessage;
import lesson22.spring.mvc.util.DtoModelsUtil;

/**
 * @author spasko
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MainMvcConfig.class })
@WebAppConfiguration
@TestPropertySource("classpath:lesson21/test.properties")
public class OrderControllerTest {
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private DataSource dataSource;

	private MockMvc mockMvc;
	private ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setup() {
		Resource initSchema = new ClassPathResource("lesson21\\script\\schema.sql");
		Resource data = new ClassPathResource("lesson21\\script\\data.sql");
		DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema, data);
		DatabasePopulatorUtils.execute(databasePopulator, dataSource);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testGetOrdersQtyBetween() throws Exception {
		MvcResult mvcResult = mockMvc.perform(get("/order").param("min", "10").param("max", "40")).andDo(print())
				.andReturn();

		assertEquals(Status.OK.getStatusCode(), mvcResult.getResponse().getStatus());
		assertEquals("application/json;charset=UTF-8", mvcResult.getResponse().getContentType());
		List<Orders> orders = getListOrdersFromResult(mvcResult);
		assertEquals(1, orders.size());
	}

	@Test
	public void testGetOrders() throws Exception {
		MvcResult mvcResult = mockMvc.perform(get("/order")).andDo(print()).andReturn();

		assertEquals(Status.OK.getStatusCode(), mvcResult.getResponse().getStatus());
		assertEquals("application/json;charset=UTF-8", mvcResult.getResponse().getContentType());
		List<Orders> orders = getListOrdersFromResult(mvcResult);
		assertEquals(2, orders.size());
	}

	@Test
	public void testGetOrderByIdExist() throws Exception {
		MvcResult mvcResult = mockMvc.perform(get("/order/{id}", "111111")).andDo(print()).andReturn();
		Orders order = mapper.readValue(mvcResult.getResponse().getContentAsString(), Orders.class);
		assertEquals(Status.OK.getStatusCode(), mvcResult.getResponse().getStatus());
		assertNotNull(order);
	}

	@Test
	public void testGetOrderByIdNotExist() throws Exception {
		MvcResult mvcResult = mockMvc.perform(get("/order/{id}", "-11")).andDo(print()).andReturn();
		assertEquals(Status.OK.getStatusCode(), mvcResult.getResponse().getStatus());
		assertTrue(mvcResult.getResponse().getContentAsString().length() == 0);
	}

	@Test
	// Test all variant of validation or in BDD tests or in separate ValidatorTest
	public void testAddOrder() throws Exception {
		String json = mapper.writeValueAsString(DtoModelsUtil.orderRequest());
		MvcResult mvcResult = mockMvc.perform(post("/order").contentType(MediaType.APPLICATION_JSON).content(json))
				.andDo(print()).andReturn();

		assertEquals(Status.OK.getStatusCode(), mvcResult.getResponse().getStatus());
	}

	@Test
	public void testDeleteOrderExist() throws Exception {
		MvcResult mvcResult = mockMvc.perform(delete("/order/{id}", "111111")).andDo(print()).andReturn();
		assertEquals(Status.OK.getStatusCode(), mvcResult.getResponse().getStatus());
	}

	@Test
	public void testDeleteOrderNotExist() throws Exception {
		MvcResult mvcResult = mockMvc.perform(delete("/order/{id}", "-11")).andDo(print()).andReturn();

		assertEquals(422, mvcResult.getResponse().getStatus());
		assertEquals("application/json;charset=UTF-8", mvcResult.getResponse().getContentType());
		ErrorMessage errorMessage = mapper.readValue(mvcResult.getResponse().getContentAsString(), ErrorMessage.class);
		assertEquals("Cannot delete Order by Id=-11, because it dont present", errorMessage.getMessage());
	}

	@Test
	public void testUpdateOrderExist() throws Exception {
		MvcResult mvcResult = mockMvc.perform(put("/order/{id}", "111111").param("qty", "777")).andDo(print())
				.andReturn();
		assertEquals(Status.OK.getStatusCode(), mvcResult.getResponse().getStatus());
	}

	@Test
	public void testUpdateOrderNotExist() throws Exception {
		MvcResult mvcResult = mockMvc.perform(put("/order/{id}", "-11").param("qty", "777")).andDo(print()).andReturn();

		assertEquals(422, mvcResult.getResponse().getStatus());
		assertEquals("application/json;charset=UTF-8", mvcResult.getResponse().getContentType());
		ErrorMessage errorMessage = mapper.readValue(mvcResult.getResponse().getContentAsString(), ErrorMessage.class);
		assertEquals("Cannot update Order by Id=-11, because it dont present", errorMessage.getMessage());
	}

	private List<Orders> getListOrdersFromResult(MvcResult mvcResult)
			throws IOException, JsonParseException, JsonMappingException, UnsupportedEncodingException {
		return mapper.readValue(mvcResult.getResponse().getContentAsString(),
				mapper.getTypeFactory().constructCollectionType(List.class, Orders.class));
	}

}
