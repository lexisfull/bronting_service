package ru.panov.bronting_service.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {

    @Bean
    public NewTopic ordersTopic() {
        return TopicBuilder
                .name("topic1")
                .build();
    }

    @Bean
    public NewTopic ordersTopic2() {
        return TopicBuilder
                .name("topic2")
                .partitions(3)
                .build();
    }
}
