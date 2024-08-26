package ru.panov.bronting_service.feighn;

import ru.panov.bronting_service.dto.ExecutorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "coachClient", url = "${client.url}")
public interface FeignCoachClient {

    @GetMapping
    ResponseEntity<List<ExecutorDTO>> getAllExecutors();
}
