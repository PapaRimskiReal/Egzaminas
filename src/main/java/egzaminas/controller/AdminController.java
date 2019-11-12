package egzaminas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import egzaminas.domain.Entry;
import egzaminas.domain.EntryProperties;
import egzaminas.repository.EntryPropertiesRepository;
import egzaminas.repository.EntryRepository;

@Controller
@RequestMapping("blog/admin")
public class AdminController {

	@Autowired
	EntryRepository entryRepository;

	@Autowired
	EntryPropertiesRepository entryPropertiesRepository;

	@GetMapping
	public String admin(@ModelAttribute("newEntry") Entry newEntry, Model model) {

		List<Entry> entryList = entryRepository.findAll();

		model.addAttribute("entryList", entryList);

		return "admin";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String newEntry(@ModelAttribute("newEntry") Entry newEntry) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();

		newEntry.setAuthor(username);

		entryRepository.save(newEntry);

		return "redirect:/blog/admin";
	}

	@RequestMapping("/deleteEntry")
	public String deleteEntry(@RequestParam("id") int entryId) {

		entryRepository.deleteById(entryId);
		return "redirect:/blog/admin";
	}
	
	@RequestMapping("/editEntry")
	public String editEntry(@RequestParam("id") int entryId, Model model, @ModelAttribute("newEntry") Entry newEntry) {

		Entry entry = entryRepository.findById(entryId).get();
		model.addAttribute("Oldentry", entry);
				
		return "editEntry";
	}
	
	@RequestMapping(value = "/editEntry", method = RequestMethod.POST)
	public String editEntryPost(@RequestParam("id") int entryId, Model model, @ModelAttribute("newEntry") Entry newEntry) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
//		newEntry.setId(entryId);
//		newEntry.setAuthor(username);
		Entry entry = entryRepository.findById(entryId).get();
		entry.setText(newEntry.getText());
		entry.setTitle(newEntry.getTitle());
		
		
		entryRepository.save(entry);
		
		return "redirect:/blog/admin";
	}

	@RequestMapping("/showEntry")
	public String showEntry(@RequestParam("id") int entryId, Model model,
			@ModelAttribute("newEntryProperties") EntryProperties newEntryProperties) {

		List<EntryProperties> EntryPropertiesList = entryPropertiesRepository.findByEntryId(entryId);
		Entry showEntry = entryRepository.findById(entryId).get();
		model.addAttribute("showEntry", showEntry);
		model.addAttribute("EntryPropertiesList", EntryPropertiesList);

		return "showEntryAdmin";
	}

	@RequestMapping("/reply")
	public String reply(@RequestParam("id") int entryPropertiesId, Model model,
			@ModelAttribute("EntryProperties") EntryProperties EntryProperties) {

		EntryProperties = entryPropertiesRepository.findById(entryPropertiesId).get();
		model.addAttribute("EntryProperties",EntryProperties);
		
		return "addComment";
	}
	
	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public String replyPost(@RequestParam("id") int entryPropertiesId, Model model,
			@ModelAttribute("EntryProperties") EntryProperties EntryProperties) {

		EntryProperties oldEntryProperties = entryPropertiesRepository.findById(entryPropertiesId).get();
		oldEntryProperties.setAnswer(EntryProperties.getAnswer());
		
		entryPropertiesRepository.save(oldEntryProperties);
		
		return "addComment";
	}
	
}
