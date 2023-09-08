package com.example.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 给KafkaTopicConfig注册Bean
 */
@Configuration
public class KafkaTopicAdministrator {
    // Logger
     private static final Logger logger = LoggerFactory.getLogger(KafkaTopicAdministrator.class);
    private final KafkaTopicConfig kafkaTopicConfig;
    private final GenericApplicationContext genericApplicationContext;

    public KafkaTopicAdministrator(KafkaTopicConfig kafkaTopicConfig, GenericApplicationContext genericApplicationContext) {
        this.kafkaTopicConfig = kafkaTopicConfig;
        this.genericApplicationContext = genericApplicationContext;
    }

    @PostConstruct
    public void init() {
        initializeBeans(kafkaTopicConfig.getTopics());
    }

    private void initializeBeans(List<KafkaTopicConfig.Topic> topics) {
        System.out.println("topics = " + topics);
        topics.forEach(topic -> {
            genericApplicationContext.registerBean(topic.getName(), NewTopic.class, topic::toNewTopic);
        });
    }
}
