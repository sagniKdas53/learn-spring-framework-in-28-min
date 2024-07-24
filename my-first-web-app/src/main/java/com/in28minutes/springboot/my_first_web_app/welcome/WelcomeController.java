package com.in28minutes.springboot.my_first_web_app.welcome;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {


    private final Logger logger = LoggerFactory.getLogger(getClass());


    private String getLoggedInUser() {
        SecurityContext securityContextHolder = SecurityContextHolder.getContext();
        return securityContextHolder.getAuthentication().getName();
    }

    @GetMapping("/")
    public String showWelcomePage(ModelMap model) {
        model.put("name", getLoggedInUser());
        return "welcome";
    }


}
