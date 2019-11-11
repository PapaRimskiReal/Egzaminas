package egzaminas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import egzaminas.domain.Entry;
import egzaminas.domain.EntryProperties;
import egzaminas.repository.EntryPropertiesRepository;
import egzaminas.repository.EntryRepository;

@Controller
@RequestMapping("blog/user")
public class UserController {

	@Autowired
	EntryRepository entryRepository;

	@Autowired
	EntryPropertiesRepository entryPropertiesRepository;

	@RequestMapping("/showEntry")
	public String showEntry(@RequestParam("id") int entryId, Model model,
			@ModelAttribute("newEntryProperties") EntryProperties newEntryProperties) {
		
		List<EntryProperties> EntryPropertiesList = entryPropertiesRepository.findByEntryId(entryId);
		Entry showEntry = entryRepository.findById(entryId).get();
		model.addAttribute("showEntry", showEntry);
		model.addAttribute("EntryPropertiesList",EntryPropertiesList);
		
		return "showEntryUser";
	}

	@RequestMapping(value = "/showEntry", method = RequestMethod.POST)
	public String newEntryProperties(@ModelAttribute("newEntryProperties") EntryProperties newEntryProperties,
			Model model, @ModelAttribute("showEntry") Entry showEntry,
			@RequestParam("id") int entryId) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();

		newEntryProperties.setUserName(username);
		newEntryProperties.setEntry(entryRepository.findById(entryId).get());
		entryPropertiesRepository.save(newEntryProperties);

		return "redirect:/blog/user/showEntry?id=" + entryId;
	}
}
