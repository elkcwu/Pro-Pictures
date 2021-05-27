package com.kwu.propictures.controller;

import com.kwu.propictures.service.GreetingService;
import com.kwu.propictures.service.LanguageGreetingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ditest")
public class DependencyInjection {
    @Autowired
    GreetingService greetingService;  //@Configuration‘s responsibility to instantiate and expose the services as beans

    @Autowired
    LanguageGreetingHelper languageGreetingHelper; //Setter Dependence Injection

    @RequestMapping("/di")
    public String home(){
        return greetingService.greet();
    }

    @RequestMapping("/setter") //http://localhost:8081/ditest/setter?language=german
    public String setterGreeting(@RequestParam String language){
        return languageGreetingHelper.greeting(language);
    }
}
