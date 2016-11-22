package com.ironyard.controler.mvc;

import com.ironyard.data.PongUser;
import com.ironyard.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Raul on 11/14/16.
 */
@Controller
public class LoginController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "mvc/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "password", required = false) String password,
                        @RequestParam(value = "username", required = false) String username,
                        HttpServletRequest request, Model model) {
        log.info("Login attempt by:"+username);
        String destination = "forward:/login.jsp";
        PongUser found = userRepository.findByUsernameAndPassword(username, password);
        if(found != null){
            // log the user in
            request.getSession().setAttribute("user",found);
            log.info("found user:" + found.getId());
            // on success we send them to the players page
            destination = "redirect:/mvc/allplayers";
        }else{
                // handle error?
                model.addAttribute("error_message", "Invalid Username or Password !");
        }
        log.info("Login attempt result:"+destination);
        return destination;
    }

    @RequestMapping(value = "mvc/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        String destination = "redirect:/login.jsp";
        PongUser found = (PongUser) request.getSession().getAttribute("user");
        if(found != null) {
            log.info("Logging out user with id:" + found.getId());
        }
        request.getSession().invalidate();
        return destination;
    }

}
