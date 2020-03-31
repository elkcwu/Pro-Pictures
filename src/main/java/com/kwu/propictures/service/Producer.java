package com.kwu.propictures.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "pictures";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    //this function send message to "topic"
    public void sendMessage(String message){
        System.out.println("+++++++++++++++++++++++ sendMessage");
        logger.info((String.format("&&& --> Producing message --> %s", message)));
        this.kafkaTemplate.send(TOPIC, message);
    }
}
