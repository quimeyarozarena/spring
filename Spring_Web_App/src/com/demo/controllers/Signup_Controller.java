package com.demo.controllers;

import com.demo.models.Signup_Model;
import java.io.File;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView doSignUpProcess(HttpServletRequest request) {

        String message = null;
        ModelAndView mav = new ModelAndView("signup");
        /*
         * String username = request.getParameter("username"); String password = request.getParameter("password");
         */

        // no se hace como arriba por este atributo en el form: enctype="multipart/form-data"

        if (ServletFileUpload.isMultipartContent(request)) {

            try {
                List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

                String username = data.get(0).getString();
                String password = data.get(1).getString();
                String repassword = data.get(2).getString();
                String gender = data.get(3).getString();
                String vehicle = data.get(4).getString();
                String country = data.get(5).getString();

                String image = new File(data.get(6).getName()).getName();

                if (password.equals(repassword)) {

                    Signup_Model sm = new Signup_Model();
                    sm.doSignUp(username, repassword, gender, vehicle, country, image);

                    // the first part redirect to project and the second part go to images inside web-inf
                    String path = request.getSession().getServletContext().getRealPath("/") + "//WEB-INF//images//";

                    data.get(6).write(new File(path + File.separator + image));

                    System.out.print(path);
                } else {
                    message = "Password doesn't match.. please try again";
                }

            } catch (Exception e) {

                message = "please try again...";
            }
        }

        mav.addObject("message", message);
        return mav;
    }

}
