package com.example.Ticket.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {

    @Query("SELECT t.jaffna FROM Ticket t WHERE t.station = :station")
    Double findJaffnaByStation(@Param("station") String station);

    @Transactional
    @Modifying
    @Query("UPDATE Ticket t SET t.jaffna = :newJaffna WHERE t.station = :station")
    void updateJaffnaByStation(@Param("station") String station, @Param("newJaffna") Double newJaffna);
}
