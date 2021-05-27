package com.kwu.propictures.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service
//@Component //@Configuration‘s responsibility to instantiate and expose the services as beans
public class EnglishGreetingService implements GreetingService{
    @Override
    public String greet() {
        return "Hi in English";
    }
}
