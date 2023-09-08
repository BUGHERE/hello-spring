package com.example.demo.config;

import lombok.Data;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 导入yml文件的topic配置到KafkaTopicConfig类中
 */
@Configuration
@ConfigurationProperties(prefix = "kafka")
@Data
public class KafkaTopicConfig {
    private static final Logger logger = LoggerFactory.getLogger(KafkaTopicConfig.class);
    private List<Topic> topics = new ArrayList<>();

    @Data
    static class Topic {
        String name = "test";
        Integer numPartitions = 3;
        Short replicationFactor = 1;

        NewTopic toNewTopic() {
            logger.info("name: {}, numPartitions: {}, replicationFactor: {}", this.name, this.numPartitions, this.replicationFactor);
            return new NewTopic(this.name, this.numPartitions, this.replicationFactor);
        }
    }
}
