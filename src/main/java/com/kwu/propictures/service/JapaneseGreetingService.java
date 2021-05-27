package com.kwu.propictures.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class JapaneseGreetingService implements SetterGreetingService{

    @Override
    public String greetSetter() {
        return "Greeting in Japanese: お元気ですか";
    }
}
