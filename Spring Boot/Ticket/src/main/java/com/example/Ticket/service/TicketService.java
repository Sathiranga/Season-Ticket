package com.example.Ticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Ticket.data.Ticket;
import com.example.Ticket.data.TicketRepository;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Double findJaffnaByStation(String station) {
        return ticketRepository.findJaffnaByStation(station);
    }

    public void updateJaffnaByStation(String station, Double newJaffna) {
        ticketRepository.updateJaffnaByStation(station, newJaffna);
    }
}
