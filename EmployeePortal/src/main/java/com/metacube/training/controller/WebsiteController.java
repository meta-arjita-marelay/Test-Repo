package com.metacube.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebsiteController {

    @RequestMapping("/")
    public String home()
    {
        return "home";
    }
}
