package com.kwu.propictures.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);
    //Kafka server and zookeeper have to be up for this to work.  It goes to Kafka to find the topic "pictures"
    //if it fail to find the topics, it will throw exception
    //temporary disable kafka,
//    @KafkaListener(topics = "pictures", groupId = "group_id")
    public void consume(String message){
        logger.info(String.format("+++ --> Consumed Message --> %s", message));
    }
}
