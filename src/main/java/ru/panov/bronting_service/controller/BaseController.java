package ru.panov.bronting_service.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.panov.bronting_service.service.kafka.KafkaProducerService;

@RequestMapping("/start")
@RestController
@RequiredArgsConstructor
public class BaseController {

    private final KafkaProducerService kafkaProducerService;

    @GetMapping("/page")
    public String getStartPage () {
        kafkaProducerService.sendMessage("Сообщение");
        return "<h1>Start page<h1/>";
    }
}
