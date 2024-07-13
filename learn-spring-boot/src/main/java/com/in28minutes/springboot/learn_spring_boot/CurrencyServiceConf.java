package com.in28minutes.springboot.learn_spring_boot;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;

@Getter
@Setter
@ConfigurationProperties("currency-service")
@Controller
public class CurrencyServiceConf {
    private String url;
    private String username;
    private String key;

}
