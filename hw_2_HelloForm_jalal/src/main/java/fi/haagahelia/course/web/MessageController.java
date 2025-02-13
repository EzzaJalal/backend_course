package fi.haagahelia.course.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.course.domain.Language;
import fi.haagahelia.course.domain.Message;


@Controller
public class MessageController {

	@RequestMapping(value = "/languagelist", method = RequestMethod.GET)
	public String listLanguages(Model model) {
		Language vietnamese = new Language();
		vietnamese.setNameOfTheLanguage("vietnamese");
		Language finnish = new Language();
		finnish.setNameOfTheLanguage("finnish");
		
		List<Language> spokenLanguages = new ArrayList<>();
		spokenLanguages.add(finnish);
		spokenLanguages.add(vietnamese);

		model.addAttribute("spokenlanguage", spokenLanguages);
		return "listlanguages";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String greetingSubmit(@ModelAttribute Message msg, Model model) {
		model.addAttribute("message", msg);
		return "result";
	}
}