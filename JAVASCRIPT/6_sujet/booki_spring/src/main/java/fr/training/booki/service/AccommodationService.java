package fr.training.booki.service;

import fr.training.booki.dto.Accommodation;
import fr.training.booki.entity.AccommodationEntity;
import fr.training.booki.repository.AccommodationRepository;
import fr.training.booki.service.mapper.AccommodationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccommodationService {

    private final AccommodationMapper accommodationMapper;
    private final AccommodationRepository accommodationRepository;

    // Conversion entities -> dto
    // Using MapStruct
    public List<Accommodation> fetchAll() {
        List<AccommodationEntity> accommodationEntities = accommodationRepository.findAll();
        return accommodationMapper.toDtoList(accommodationEntities);
    }

    public List<Accommodation> searchByCity(String city) {
        List<AccommodationEntity> accommodationEntities = accommodationRepository.findByCityName(city);
        return accommodationMapper.toDtoList(accommodationEntities);
    }
}
