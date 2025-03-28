package fr.training.booki.service.mapper;

import fr.training.booki.dto.Accommodation;
import fr.training.booki.entity.AccommodationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = CityMapper.class)
public interface AccommodationMapper {

    @Mapping(source = "city", target = "city")
    Accommodation toDto(AccommodationEntity entity);

    @Mapping(source = "city", target = "city")
    AccommodationEntity toEntity(Accommodation accommodation);

    List<Accommodation> toDtoList(List<AccommodationEntity> entityList);
}