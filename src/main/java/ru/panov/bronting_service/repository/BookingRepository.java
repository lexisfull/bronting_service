package ru.panov.bronting_service.repository;

import ru.panov.bronting_service.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = """
            select * from booking
            where executor_id = :executorId
            and date_time > NOW()
            """, nativeQuery = true)
    List<Booking> findAllByExecutorId(Long executorId);
}
