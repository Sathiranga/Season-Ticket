package com.example.seasonproject.controller;

import com.example.seasonproject.data.Season;
import com.example.seasonproject.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class SeasonController {
    @Autowired
    private SeasonService seasonService;

    @PostMapping(path = "/seasons")
    public Season createSeason(@RequestBody Season season) {
        return seasonService.createSeason(season);
    }

    @GetMapping(path = "/seasons/{id}")
    public Season getSeasonById(@PathVariable int id) {
        return seasonService.getSeasonById(id);
    }




    @PutMapping(path = "/{id}/seasons")
    public Season updateAttendanceAndType(@PathVariable int id, @RequestParam String newSeasonType) {
        return seasonService.updateAttendanceAndType(id, newSeasonType);
    }

    @PutMapping(path = "/seasons/{id}/attendances")
    public Season updateAttendanceAndCheckExpiration(@PathVariable int id) {
        return seasonService.updateAttendanceAndCheckExpiration(id);
    }

    @PostMapping(path = "/{id}/seasons")
    public void sendRegistrationEmail(@PathVariable int id, @RequestBody Map<String, String> emailMap) {
        Season season = seasonService.getSeasonById(id);
        if (season != null) {
            seasonService.sendRegistrationEmail(emailMap.get("email"), season.getId(), season.getQrCodeContent());
        }
    }

    @PostMapping(path = "seasons/{id}/qrs")
    public Season scanQRCode(@PathVariable int id) {
        return seasonService.scanQRCode(id);
    }
}
