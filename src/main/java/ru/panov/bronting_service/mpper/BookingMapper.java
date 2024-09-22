package ru.panov.bronting_service.mpper;

import org.mapstruct.Mapper;
import ru.panov.bronting_service.dto.BookingDto;
import ru.panov.bronting_service.entity.Booking;

@Mapper
public interface BookingMapper {

    BookingDto toBookingDto(Booking booking);
    Booking toBooking(BookingDto bookingDto);
}
