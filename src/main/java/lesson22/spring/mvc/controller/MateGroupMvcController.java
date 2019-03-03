package lesson22.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lesson10.xmljson.MateGroup;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author spasko
 */

@Controller
@RequestMapping("/mvc")
@ApiIgnore
public class MateGroupMvcController {

	private MateGroup mateGroup = MateGroup.mateGroupExampleCreator();

	@GetMapping
	public String index(@Validated String groupId, Model model) {
		if (groupId != null && groupId.equals("" + mateGroup.getId())) {
			model.addAttribute("model", mateGroup);
		}
		return "indexMvc";
	}

}
