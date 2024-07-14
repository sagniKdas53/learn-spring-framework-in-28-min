package com.in28minutes.springboot.my_first_web_app.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private AuthIntf authService;

    LoginController(@Qualifier("authNamedService") AuthIntf authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

//    @PostMapping(path = "/login", consumes = "application/x-www-form-urlencoded")
//    public String showWelcomePage(@RequestBody String data, ModelMap model) {
//        String username = data.split("&")[0].split("=")[1];
//        model.put("username", username);
//        logger.debug(data);
//        return "welcome";
//    }

    @PostMapping(path = "/login", consumes = "application/x-www-form-urlencoded")
    public String showWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
        model.put("name", name);
        model.put("password", password);
        logger.info("{\"name\":\"{}\", \"password\":\"{}\"}", name, password);
        if (!authService.validate(name, password)) {
            getDebug(name, password);
            model.put("error", "Invalid username or password");
            return "login";
        }
        return "welcome";
    }

    @PostMapping(path = "/login-param", consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public String echoBack(@RequestBody String data) {
        return data;
    }

    @GetMapping(path = "/login-param-return-json", produces = "application/json")
    @ResponseBody
    public String echoBackJson(@RequestParam String name, @RequestParam String password) {
        return "{\"name\":\"" + name + "\", \"password\":\"" + password + "\"}";
    }

    @GetMapping(path = "/login-param-welcome")
    public String echoBackJSP(@RequestParam String name, @RequestParam String password, ModelMap model) {
        model.put("name", name);
        getDebug(name, password);
        return "welcome";
    }

    private void getDebug(String name, String password) {
        logger.debug("{\"name\":\"{}\", \"password\":\"{}\"}", name, password);
    }

}
