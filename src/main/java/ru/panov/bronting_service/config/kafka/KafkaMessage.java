package ru.panov.bronting_service.config.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaMessage {

    private final KafkaSender sender;

    @Scheduled(fixedDelay = 5000)
    public void setSender(){
        log.info("Отправка сообщения");
        sender.send("topic1", "message");
    }

}
