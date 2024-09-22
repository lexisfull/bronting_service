package ru.panov.bronting_service;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.panov.bronting_service.feighn.FeignCoachClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(clients = FeignCoachClient.class)
@EnableScheduling
public class BrontingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrontingServiceApplication.class, args);
    }

}
