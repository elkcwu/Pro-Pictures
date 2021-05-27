package com.kwu.propictures.service;

import org.springframework.stereotype.Component;

@Component
public class GermanGreetingService implements SetterGreetingService{
    @Override
    public String greetSetter() {
        return "Greeting in German: wie gehts";
    }
}
