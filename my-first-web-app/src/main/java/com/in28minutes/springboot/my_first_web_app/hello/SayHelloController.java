package com.in28minutes.springboot.my_first_web_app.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello World";
    }

    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHtml(){
        return """
                <html>
                    <head>
                        <title>Hello World</title>
                    </head>
                    <body>
                        <h1>Hello World</h1>
                        <p>This is a HTML response</p>
                    </body>
                """;
    }

//    @RequestMapping("say-hello-jsp")
//    public String sayJsp(){
//        return "sayHello";
//    }
}
