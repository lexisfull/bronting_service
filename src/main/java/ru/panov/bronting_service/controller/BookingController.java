package ru.panov.bronting_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.panov.bronting_service.dto.BookingDto;
import ru.panov.bronting_service.service.BookingService;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;


    /**
     * Эндпоинт для получения свободных дат для записи
     *
     * @param executorId
     * @return
     */
    @GetMapping("booking/{executorId}")
    public ResponseEntity<List<LocalDateTime>> getFreeReservation(@PathVariable Long executorId) {
        return ResponseEntity.ok(bookingService.getFreeReservation(executorId));
    }

    @PostMapping
    public ResponseEntity<?> createBooking(BookingDto booking) {
        return ResponseEntity.ok(bookingService.createBooking(booking));
    }
}
