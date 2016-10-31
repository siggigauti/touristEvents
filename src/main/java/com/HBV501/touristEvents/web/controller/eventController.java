package com.HBV501.touristEvents.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Siggigauti on 15/10/2016.
 */
@Controller
public class eventController {

    @Autowired

    @RequestMapping("/")
    public String homepage() {
        //Þetta home er nafn á html skjali undir resources/templates. Öll html skjöl verða þar.
        return "home";
    }

    @RequestMapping("/test")
    public String testPage() {
        //Þetta home er nafn á html skjali undir resources/templates. Öll html skjöl verða þar.
        return "testFile";
    }
}
