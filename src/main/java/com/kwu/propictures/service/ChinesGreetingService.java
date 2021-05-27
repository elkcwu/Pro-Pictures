package com.kwu.propictures.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component  //@Configuration‘s responsibility to instantiate and expose the services as beans
public class ChinesGreetingService implements GreetingService{
    @Override
    public String greet() {
        return "Hi in Chinese: 你好吗";
    }
}
