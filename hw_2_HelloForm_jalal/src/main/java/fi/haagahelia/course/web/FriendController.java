package fi.haagahelia.course.web;

import fi.haagahelia.course.domain.Friend;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FriendController {

    private List<Friend> friends = new ArrayList<>();

    @RequestMapping(value = "/friends", method = RequestMethod.GET)
    public String showFriends(Model model) {
        model.addAttribute("friends", friends);
        return "friendlist";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addFriendForm(Model model) {
        model.addAttribute("friend", new Friend());
        return "addfriend";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addFriend(@ModelAttribute Friend friend) {
        friends.add(friend);
        return "redirect:/friends";
    }
}
