package ru.panov.bronting_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.panov.bronting_service.dto.BookingDto;
import ru.panov.bronting_service.entity.Booking;
import ru.panov.bronting_service.mpper.BookingMapper;
import ru.panov.bronting_service.repository.BookingRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    /**
     * генер``Zирует список свободных дат для записи
     * в случае списка занятых дат более 8, вернуть пустой список
     *
     * @param executorId id исполнителя
     * @return список свободных для записи дат
     */
    public List<LocalDateTime> getFreeReservation(Long executorId){

        LocalDateTime time = LocalDateTime.now();
        time = time.plusDays(1).truncatedTo(ChronoUnit.DAYS).plusHours(8).truncatedTo(ChronoUnit.HOURS);
        List<LocalDateTime> freeTime = new ArrayList<>();
        for (int i = 0; i < 140; i++) {
            time = time.plusHours(1);
            if (time.getHour() > 22) {
                time = time.plusDays(1).truncatedTo(ChronoUnit.DAYS);
            }
            freeTime.add(time);
        }

        List<LocalDateTime> freeReservation = bookingRepository.findAllByExecutorId(executorId)
                .stream().map(Booking::getDateTime).collect(Collectors.toList());
        if (!freeReservation.isEmpty()) {
            freeTime.removeAll(freeReservation);
            return freeTime;
        }
        return freeTime;
    }

    public ResponseEntity<?> createBooking(BookingDto booking) {
        bookingRepository.save(bookingMapper.toBooking(booking));
        return ResponseEntity.ok().build();
    }
}
