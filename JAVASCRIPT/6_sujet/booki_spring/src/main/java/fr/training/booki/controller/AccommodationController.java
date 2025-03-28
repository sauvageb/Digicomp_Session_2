package fr.training.booki.controller;

import fr.training.booki.dto.Accommodation;
import fr.training.booki.service.AccommodationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/accommodations")
public class AccommodationController {

    private final AccommodationService accommodationService;

    // /api/accommodations
    // /api/accommodations?city=Marseille
    @GetMapping
    public ResponseEntity<List<Accommodation>> all(
            @RequestParam(value = "city", required = false) String cityParam) {

        List<Accommodation> accommodationList;
        if (Objects.isNull(cityParam) || cityParam.isEmpty()) {
            accommodationList = accommodationService.fetchAll();
        } else {
            accommodationList = accommodationService.searchByCity(cityParam);
        }
        return ResponseEntity.ok(accommodationList);
    }

}
