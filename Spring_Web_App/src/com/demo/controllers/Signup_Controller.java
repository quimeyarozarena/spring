package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Signup_Controller {

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView load_signup() {

        ModelAndView mav = new ModelAndView("signup");

        return mav;
    }

}
