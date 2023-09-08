package com.example.demo.service;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@AllArgsConstructor
public class BookProducerService {
    private static final Logger logger = LoggerFactory.getLogger(BookProducerService.class);
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String topic, Object o) {
        // 除了topic和发送内容，可以设置分区编号，时间戳等
        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(topic, o);
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(producerRecord);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable ex) {
                logger.error("Unable to send message=[{}] due to : {}", o, ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                logger.info("Sent message=[{}]", o);
            }
        });
    }
}
