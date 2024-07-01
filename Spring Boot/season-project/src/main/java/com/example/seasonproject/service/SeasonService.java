package com.example.seasonproject.service;

import com.example.seasonproject.data.Season;
import com.example.seasonproject.data.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeasonService {
    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    public Season createSeason(Season season) {
        Season createdSeason = seasonRepository.save(season);

        // Generate the qr code
        String qrCodeContent = generateQRCodeContent(season);
        createdSeason.setQrCodeContent(qrCodeContent);

        // Send registration success email
        sendRegistrationEmail(season.getEmail(), createdSeason.getId(), qrCodeContent);

        return createdSeason;
    }

    private String generateQRCodeContent(Season season) {
        return String.format("Name: %s, Email: %s, Season ID: %d", season.getName(), season.getEmail(), season.getId());
    }

    public void sendRegistrationEmail(String userEmail, int seasonId, String qrCodeContent) {
        String subject = "Registration Successful";
        String body = "Thank you for registering! Your season ID is: " + seasonId +
                "\n\nHere is your QR code content:\n\n" + qrCodeContent;

        emailSenderService.sendEmail(userEmail, subject, body);
    }

    public Season getSeasonById(int id) {
        Optional<Season> season = seasonRepository.findById(id);
        return season.orElse(null);
    }



    public Season updateAttendanceAndType(int id, String newSeasonType) {
        Optional<Season> seasonOptional = seasonRepository.findById(id);
        if (seasonOptional.isPresent()) {
            Season season = seasonOptional.get();
            season.setAttendance(0); // Reset attendance to 0
            season.setSeasonType(newSeasonType); // Update season type

            return seasonRepository.save(season);
        }
        return null;
    }

    public Season updateAttendanceAndCheckExpiration(int id) {
        Optional<Season> seasonOptional = seasonRepository.findById(id);
        if (seasonOptional.isPresent()) {
            Season season = seasonOptional.get();
            season.setAttendance(season.getAttendance() + 1);

            // Check for expiration
            if (season.getAttendance() >= Integer.parseInt(season.getSeasonType())) {
                sendExpirationEmail(season.getEmail());
            }

            return seasonRepository.save(season);
        }
        return null;
    }

    public Season scanQRCode(int id) {
        Optional<Season> seasonOptional = seasonRepository.findById(id);
        if (seasonOptional.isPresent()) {
            return updateAttendanceAndCheckExpiration(id);
        }
        return null;
    }

    private void sendExpirationEmail(String userEmail) {
        String subject = "Season Expired";
        String body = "Your season has expired. Thank you for your participation.";

        emailSenderService.sendEmail(userEmail, subject, body);
    }
}
