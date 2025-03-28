package fr.training.booki.service.mapper;

import fr.training.booki.dto.City;
import fr.training.booki.entity.CityEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {

    // Mapping pour CityEntity -> City
    City toDto(CityEntity cityEntity);

    // Mapping inverse pour City -> CityEntity
    CityEntity toEntity(City city);
}