package com.example.demo.service;

import com.example.demo.entity.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BookConsumerService {

    @Value("${kafka.topic.my-topic}")
    private String myTopic;
    @Value("${kafka.topic.my-topic2}")
    private String myTopic2;
    private final Logger logger = LoggerFactory.getLogger(BookProducerService.class);
    private final ObjectMapper objectMapper = new ObjectMapper();


    @KafkaListener(topics = {"${kafka.topic.my-topic}"}, groupId = "group1")
    public void consumeMessage(ConsumerRecord<String, String> bookConsumerRecord) {
        try {
            Book book = objectMapper.readValue(bookConsumerRecord.value(), Book.class);
            logger.info("consumer in group1 topic: {} partition:{}, message -> {}", bookConsumerRecord.topic(), bookConsumerRecord.partition(), book.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = {"${kafka.topic.my-topic2}"}, groupId = "group2")
    public void consumeMessage2(Book book) {
        logger.info("consumer in group2 topic: {}, message -> {}", myTopic2, book.toString());
    }
}

