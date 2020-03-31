package com.kwu.propictures.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    //temporary disable kafka
//    @KafkaListener(topics = "pictures", groupId = "group_id")
    public void consume(String message){
        logger.info(String.format("+++ --> Consumed Message --> %s", message));
    }
}
