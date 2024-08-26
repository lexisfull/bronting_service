package service;

import Entity.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import repository.BookingRepository;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    public ResponseEntity<Booking> getFreeReservation(Long executorId){

        ZonedDateTime time = ZonedDateTime.now();
        time = time.truncatedTo(ChronoUnit.HOURS);
        List<ZonedDateTime> freeTime = new ArrayList<>();
        for (int i = 0; i < 140; i++) {
            time = time.plusHours(1);
            if (time.getHour() > 22) {
                time = time.plusHours(10);
            }
            freeTime.add(time);
        }
        List<ZonedDateTime> freeReservation = bookingRepository.findByBookingId(executorId);
        return null;
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }
}
