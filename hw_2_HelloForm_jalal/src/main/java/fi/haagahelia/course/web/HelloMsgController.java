package fi.haagahelia.course.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloMsgController {
    @RequestMapping(value = "/hellomsg", method = RequestMethod.GET)
    public String handleHello(@RequestParam(name = "name") String name, @RequestParam int age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "hellomsg";
    }
}
