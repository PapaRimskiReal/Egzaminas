package egzaminas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import egzaminas.domain.Login;
import egzaminas.repository.LoginRepository;

@Controller
@RequestMapping("blog/registration")
@Validated
public class RegistrationController {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@RequestMapping
	public String getNewLogin(@ModelAttribute("newLogin") Login newLogin) {
		
		return "registration";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String postNewLogin(@ModelAttribute("newLogin") Login newLogin) {
		
		newLogin.setRole("user");
		
		loginRepository.save(newLogin);
		
		return "redirect:/blog";
	}

}
