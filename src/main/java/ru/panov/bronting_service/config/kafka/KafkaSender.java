package ru.panov.bronting_service.config.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class KafkaSender {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, String message) {

        log.info("Sending : {}", message);
        log.info("--------------------------------");

        kafkaTemplate.send(topic, message);
    }
}
