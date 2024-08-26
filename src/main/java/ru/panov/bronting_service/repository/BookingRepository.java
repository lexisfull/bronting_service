package repository;

import Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = """
            select date_time from booking
            where id = :id 
            and date_time > :dateTime
            """, nativeQuery = true)
    List<ZonedDateTime> findByBookingId(Long id);
}
