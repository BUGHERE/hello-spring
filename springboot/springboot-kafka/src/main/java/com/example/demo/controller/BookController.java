package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookProducerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author shuang.kou
 */
@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Value("${kafka.topics[0].name}")
    String topic1;
    @Value("${kafka.topics[1].name}")
    String topic2;
    private final BookProducerService producer;
    private AtomicLong atomicLong = new AtomicLong();

    BookController(BookProducerService producer) {
        this.producer = producer;
    }

    @PostMapping
    public void sendMessageToKafkaTopic(@RequestParam("name") String name) {
        this.producer.sendMessage(topic1, new Book(atomicLong.addAndGet(1), name));
        this.producer.sendMessage(topic2, new Book(atomicLong.addAndGet(1), name));
    }
}