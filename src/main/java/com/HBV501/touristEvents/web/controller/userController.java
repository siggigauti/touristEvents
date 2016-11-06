package com.HBV501.touristEvents.web.controller;

import com.HBV501.touristEvents.model.Event;
import com.HBV501.touristEvents.model.User;
import com.HBV501.touristEvents.service.UserService;
import com.HBV501.touristEvents.web.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;

/**
 * Created by Siggigauti on 06/11/2016.
 */
@Controller
public class userController {
    @Autowired
    private UserService userService;

    // Form for adding a new user
    @RequestMapping("/user/add")
    public String formNewUser(Model model) {

        if(!model.containsAttribute("user")) {
            model.addAttribute("user",new User());
        }
        model.addAttribute("action","/user");
        model.addAttribute("heading","New User");
        model.addAttribute("submit","Add");

        return "userForm";
    }

    // Add a user
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            // Include validation errors upon redirect
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user",result);

            // Add  category if invalid was received
            redirectAttributes.addFlashAttribute("user", user);

            // Redirect back to the form
            return "redirect:/user/add";
        }
        user.setCompany(false);
        userService.save(user);

        return "redirect:/";
    }
}
