package com.HBV501.touristEvents.web.controller;

import com.HBV501.touristEvents.model.Event;
import com.HBV501.touristEvents.model.User;
import com.HBV501.touristEvents.service.UserService;
import com.HBV501.touristEvents.web.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpSession;
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
    public String addUser(@Valid User user, BindingResult result, RedirectAttributes redirectAttributes, HttpSession session) {
        if(result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user",result);
            redirectAttributes.addFlashAttribute("user", user);
            return "redirect:/user/add";
        }
        user.setCompany(false);
        userService.save(user);

        return "redirect:/";
    }

    @RequestMapping(value = "/user/{name}")
    public String userName(@PathVariable Long name, Model model, HttpSession session){
        User user = userService.findById(name);
        session.setAttribute("myUser", user);
        User sessionUser = (User) session.getAttribute("myUser");
        model.addAttribute("name", sessionUser.getName());
        return "username";
    }

    //Bæta við login falli sem tekur /login
    @RequestMapping("/login")
    public String loginForm(){
        return "login";
    }

    @RequestMapping(value ="/login", method = RequestMethod.POST)
    public String loginHandler(HttpSession session, @RequestParam Long id, Model model){
        User user = userService.findById(id);
        session.setAttribute("myUser", user);
        return "redirect:/events";
    }

}
