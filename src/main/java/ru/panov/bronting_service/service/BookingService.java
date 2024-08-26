package ru.panov.bronting_service.service;

import lombok.RequiredArgsConstructor;
import ru.panov.bronting_service.entity.Booking;
import org.springframework.stereotype.Service;
import ru.panov.bronting_service.repository.BookingRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    /**
     * генерирует список свободных дат для записи
     * в случае списка занятых дат более 8, вернуть пустой список
     *
     * @param executorId
     * @return
     */
    public  List<LocalDateTime>  getFreeReservation(Long executorId){

        ZonedDateTime time = ZonedDateTime.now().truncatedTo(ChronoUnit.HOURS);
        List<LocalDateTime> freeTime = new ArrayList<>();
        for (int i = 0; i < 140; i++) {
            time = time.plusHours(1);
            if (time.getHour() < 8) {
                time = ZonedDateTime.now().truncatedTo(ChronoUnit.DAYS);
                time = time.plusHours(8);
            }
            if (time.getHour() > 22) {
                time = ZonedDateTime.now().truncatedTo(ChronoUnit.DAYS).plus(1, ChronoUnit.DAYS).truncatedTo(ChronoUnit.HOURS);
                time = time.plusHours(8);
            }
            freeTime.add(time.toLocalDateTime());
        }
        List<LocalDateTime> freeReservation = bookingRepository.findAllByExecutorId(executorId)
                .stream().map(Booking::getDateTime).map(ZonedDateTime::toLocalDateTime).toList();
        if (!freeReservation.isEmpty()) {
            freeTime.removeAll(freeReservation);
            return freeTime;
        }
        return freeTime;
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }
}
