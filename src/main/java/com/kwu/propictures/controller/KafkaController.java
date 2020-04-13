package com.kwu.propictures.controller;

import com.kwu.propictures.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    Producer producer;

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message){
        System.out.println("+++++++++++++++++++++++ sendMessageToKafkaTopic");
        this.producer.sendMessage(message);
    }
}
