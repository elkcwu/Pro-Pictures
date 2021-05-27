package com.kwu.propictures.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//https://stormpath.com/blog/spring-boot-dependency-injection

//setter injection
@Component
public class LanguageGreetingHelper {
    private SetterGreetingService japanese;
    private SetterGreetingService german;


    public String greeting(String language){
        switch(language){
            case "japanese":
                return japanese.greetSetter();
            case "german":
                return german.greetSetter();
            default:
                return "UNKNOWN";
        }
    }

//    @Autowired  //constructor injection
//    LanguageGreetingHelper(@Qualifier("japaneseGreetingService") SetterGreetingService japanese){
//        this.japanese = japanese;
//    }


    @Autowired  //setter injection
    public void setJapanese(@Qualifier("japaneseGreetingService") SetterGreetingService japanese){
        this.japanese = japanese;
    }

    @Autowired
    @Qualifier("germanGreetingService")
    public void setGerman(SetterGreetingService german){
        this.german = german;
    }
}
