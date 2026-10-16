package ma.clicktrack.controller;

import ma.clicktrack.dto.LienRequestDto;
import ma.clicktrack.dto.LienResponseDto;
import ma.clicktrack.dto.PublisherResponseDto;
import ma.clicktrack.model.Lien;
import ma.clicktrack.model.Publisher;
import ma.clicktrack.service.LienService;
import ma.clicktrack.service.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController // Combines @Controller and @ResponseBody
public class ClickTrackController {

    private final PublisherService publisherService;
    private final LienService lienService;

    // Constructor injection
    public ClickTrackController(PublisherService publisherService, LienService lienService) {
        this.publisherService = publisherService;
        this.lienService = lienService;
    }

    // 1. GET /api/publishers - List all publishers (200 OK)[cite: 3]
    @GetMapping("/api/publishers")
    public ResponseEntity<List<PublisherResponseDto>> getAllPublishers() {
        try {
            List<Publisher> publishers = publisherService.getAllPublishers();
            List<PublisherResponseDto> dtos = publishers.stream()
                    .map(PublisherResponseDto::from)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    // 2. GET /api/publishers/{id}/liens - List a publisher's links (200 OK)[cite:
    // 3]
    @GetMapping("/api/publishers/{id}/liens")
    public ResponseEntity<List<LienResponseDto>> getPublisherLiens(@PathVariable("id") Long id) {
        try {
            List<Lien> liens = lienService.getPublisherLinks(id);
            List<LienResponseDto> dtos = liens.stream()
                    .map(LienResponseDto::from)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    // 3. GET /api/liens - Get specific link info using tracking link as ID
    @GetMapping("/api/liens")
    public ResponseEntity<LienResponseDto> getLienByValue(@RequestParam String lienValue) {
        try {
            Lien lien = lienService.getLienByValue(lienValue);
            if (lien != null) {
                return ResponseEntity.ok(LienResponseDto.from(lien));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    // // 3. GET /api/publishers/{id}/offres - List a publisher's offers (200
    // OK)[cite: 3]
    // @GetMapping("/api/publishers/{id}/offres")
    // public ResponseEntity<?> getPublisherOffres(@PathVariable Long id) {
    // // TODO: Implement logic using service
    // return ResponseEntity.ok().build();
    // }
    //
    // 4. POST /api/publishers/{id}/liens - Create a tracking link (201
    // Created)[cite: 3]
    @PostMapping("/api/publishers/{id}/liens")
    public ResponseEntity<LienResponseDto> createLien(@PathVariable("id") Long id,
            @RequestBody LienRequestDto lienRequest) {
        try {
            String destinationUrl = lienRequest.destinationUrl();
            if (destinationUrl == null || destinationUrl.trim().isEmpty()) {
                return ResponseEntity.badRequest().build(); // HTTP 400 Bad Request
            }
            Lien lien = lienService.create(id, destinationUrl);
            if (lien != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(LienResponseDto.from(lien));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}