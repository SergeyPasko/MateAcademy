package lesson23.spring.security;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

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
public class OrderControllerSecurityTest {
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
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.apply(SecurityMockMvcConfigurers.springSecurity()).build();
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	public void testAddOrderAuth() throws Exception {
		String json = mapper.writeValueAsString(DtoModelsUtil.orderRequest());
		MvcResult mvcResult = mockMvc.perform(post("/order").contentType(MediaType.APPLICATION_JSON).content(json))
				.andDo(print()).andReturn();

		assertEquals(Status.OK.getStatusCode(), mvcResult.getResponse().getStatus());
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	public void testDeleteOrderExistAuth() throws Exception {
		MvcResult mvcResult = mockMvc.perform(delete("/order/{id}", "111111")).andDo(print()).andReturn();
		assertEquals(Status.OK.getStatusCode(), mvcResult.getResponse().getStatus());
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	public void testDeleteOrderNotExistAuth() throws Exception {
		MvcResult mvcResult = mockMvc.perform(delete("/order/{id}", "-11")).andDo(print()).andReturn();

		assertEquals(422, mvcResult.getResponse().getStatus());
		assertEquals("application/json;charset=UTF-8", mvcResult.getResponse().getContentType());
		ErrorMessage errorMessage = mapper.readValue(mvcResult.getResponse().getContentAsString(), ErrorMessage.class);
		assertEquals("Cannot delete Order by Id=-11, because it dont present", errorMessage.getMessage());
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	public void testUpdateOrderExistAuth() throws Exception {
		MvcResult mvcResult = mockMvc.perform(put("/order/{id}", "111111").param("qty", "777")).andDo(print())
				.andReturn();
		assertEquals(Status.OK.getStatusCode(), mvcResult.getResponse().getStatus());
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	public void testUpdateOrderNotExistAuth() throws Exception {
		MvcResult mvcResult = mockMvc.perform(put("/order/{id}", "-11").param("qty", "777")).andDo(print()).andReturn();

		assertEquals(422, mvcResult.getResponse().getStatus());
		assertEquals("application/json;charset=UTF-8", mvcResult.getResponse().getContentType());
		ErrorMessage errorMessage = mapper.readValue(mvcResult.getResponse().getContentAsString(), ErrorMessage.class);
		assertEquals("Cannot update Order by Id=-11, because it dont present", errorMessage.getMessage());
	}

	@Test
	public void testAddOrderNoAuth() throws Exception {
		String json = mapper.writeValueAsString(DtoModelsUtil.orderRequest());
		MvcResult mvcResult = mockMvc.perform(post("/order").contentType(MediaType.APPLICATION_JSON).content(json))
				.andDo(print()).andReturn();

		checkUnauthorizedStatus(mvcResult);
	}

	@Test
	public void testDeleteOrderExistNoAuth() throws Exception {
		MvcResult mvcResult = mockMvc.perform(delete("/order/{id}", "111111")).andDo(print()).andReturn();
		checkUnauthorizedStatus(mvcResult);
	}

	@Test
	public void testDeleteOrderNotExistNoAuth() throws Exception {
		MvcResult mvcResult = mockMvc.perform(delete("/order/{id}", "-11")).andDo(print()).andReturn();

		checkUnauthorizedStatus(mvcResult);
	}

	private void checkUnauthorizedStatus(MvcResult mvcResult) {
		assertEquals(Status.UNAUTHORIZED.getStatusCode(), mvcResult.getResponse().getStatus());
	}

	@Test
	public void testUpdateOrderExistNoAuth() throws Exception {
		MvcResult mvcResult = mockMvc.perform(put("/order/{id}", "111111").param("qty", "777")).andDo(print())
				.andReturn();
		checkUnauthorizedStatus(mvcResult);
	}

	@Test
	public void testUpdateOrderNotExistNoAuth() throws Exception {
		MvcResult mvcResult = mockMvc.perform(put("/order/{id}", "-11").param("qty", "777")).andDo(print()).andReturn();
		checkUnauthorizedStatus(mvcResult);
	}

}
