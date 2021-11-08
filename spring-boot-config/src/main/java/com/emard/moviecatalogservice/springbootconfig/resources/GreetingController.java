package com.emard.moviecatalogservice.springbootconfig.resources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RefreshScope
public class GreetingController {

    private final Environment env;
    private final DbSettings dbSettings;

    GreetingController(Environment env, DbSettings dbSettings){
        this.env = env;
        this.dbSettings = dbSettings;
    }

    @Value("${my.greeting}")
    private String greetingMsg;

    @GetMapping("/greeting")
    public String greeting(){
        return greetingMsg+ " conn ="+dbSettings.getConnection()+ " - port="+dbSettings.getPort();
    }

    @GetMapping("/envDetails")
    public String envDetails(){
        return env.toString();
    }
}
