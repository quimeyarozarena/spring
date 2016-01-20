package com.demo.controllers;

import com.demo.models.Login_Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Login_Controller {

    /*
     * @RequestMapping(value = "/login", method = RequestMethod.GET) public ModelAndView loadloginpage() {
     * 
     * ModelAndView mav = new ModelAndView("login");
     * 
     * System.out.println("login method has been call"); return mav; }
     */

    @RequestMapping(value = "/login", method = RequestMethod.GET) // hacer lo mismo que arriba
    public String loadloginpage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST) // hacer lo mismo que arriba
    public String do_login(HttpServletRequest req, Model md, HttpSession session) {

        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            System.out.println("username: " + username + " password: " + password);

            Login_Model lm = new Login_Model();
            String message = lm.do_login_proces(username, password);

            if (message.contentEquals("login success")) {

                session.setAttribute("username", username);
                return "redirect:/myprofile";
            } else {
                md.addAttribute("error_msg", message);
            }

            return "login";
        } catch (Exception e) {
            return "login";
        }

    }
}
