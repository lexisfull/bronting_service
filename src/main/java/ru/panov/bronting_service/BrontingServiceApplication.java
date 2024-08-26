package ru.panov.bronting_service;

import ru.panov.bronting_service.feighn.FeignCoachClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(clients = FeignCoachClient.class)
public class BrontingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrontingServiceApplication.class, args);
    }

}
