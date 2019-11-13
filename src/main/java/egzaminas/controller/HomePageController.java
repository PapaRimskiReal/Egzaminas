package egzaminas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import egzaminas.domain.Entry;
import egzaminas.repository.EntryRepository;
import egzaminas.repository.LoginRepository;

@Controller
@RequestMapping("/blog")
public class HomePageController {

	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	EntryRepository entryRepository;

	/**
	 * Home page mapping
	 */
	@GetMapping
	public String pradzia(Model model) {

		List<Entry> entryList = entryRepository.findAll();
		
		model.addAttribute("entryList", entryList);
		
		return "blog";
	}

}
