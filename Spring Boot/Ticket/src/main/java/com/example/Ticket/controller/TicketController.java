package com.example.Ticket.controller;

import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bind.annotation.Origin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Ticket.service.TicketService;

@CrossOrigin
@RestController
@RequestMapping("/api")
class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/tickets/{station}/jaffna")
    public Double getJaffnaForStation(@PathVariable String station) {
        return ticketService.findJaffnaByStation(station);
    }

    @PutMapping("/tickets/{station}/jaffna")
    public void updateJaffnaForStation(@PathVariable String station, @RequestParam Double newJaffna) {
        ticketService.updateJaffnaByStation(station, newJaffna);
    }
}
