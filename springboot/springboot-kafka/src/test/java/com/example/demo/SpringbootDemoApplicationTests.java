package com.example.demo;

import com.example.demo.entity.Book;
import com.example.demo.service.BookProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootDemoApplicationTests {
    @Value("${kafka.topics[0].name}")
    String topic1;
    @Value("${kafka.topics[1].name}")
    String topic2;
    @Autowired
    BookProducerService producer;

    /**
     * consumer无法成功消费消息
     * 因为这里producer发送消息后，程序就结束了
     */
    @Test
    void contextLoads() {
        this.producer.sendMessage(topic1, new Book(1L, "111"));
        this.producer.sendMessage(topic2, new Book(2L, "222"));
    }

}
