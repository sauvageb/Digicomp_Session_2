package fr.training.booki.service.mapper;

import fr.training.booki.dto.City;
import fr.training.booki.entity.CityEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-27T11:44:57+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class CityMapperImpl implements CityMapper {

    @Override
    public City toDto(CityEntity cityEntity) {
        if ( cityEntity == null ) {
            return null;
        }

        City city = new City();

        city.setId( cityEntity.getId() );
        city.setName( cityEntity.getName() );
        city.setZipcode( cityEntity.getZipcode() );

        return city;
    }

    @Override
    public CityEntity toEntity(City city) {
        if ( city == null ) {
            return null;
        }

        CityEntity cityEntity = new CityEntity();

        cityEntity.setId( city.getId() );
        cityEntity.setName( city.getName() );
        cityEntity.setZipcode( city.getZipcode() );

        return cityEntity;
    }
}
