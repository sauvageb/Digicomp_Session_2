package fr.training.booki.service.mapper;

import fr.training.booki.dto.Accommodation;
import fr.training.booki.entity.AccommodationEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-27T11:44:57+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class AccommodationMapperImpl implements AccommodationMapper {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public Accommodation toDto(AccommodationEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Accommodation.AccommodationBuilder accommodation = Accommodation.builder();

        accommodation.city( cityMapper.toDto( entity.getCity() ) );
        accommodation.id( entity.getId() );
        accommodation.title( entity.getTitle() );
        accommodation.description( entity.getDescription() );
        accommodation.address( entity.getAddress() );
        accommodation.price( entity.getPrice() );
        accommodation.rating( entity.getRating() );
        accommodation.capacity( entity.getCapacity() );
        accommodation.pictureUrl( entity.getPictureUrl() );

        return accommodation.build();
    }

    @Override
    public AccommodationEntity toEntity(Accommodation accommodation) {
        if ( accommodation == null ) {
            return null;
        }

        AccommodationEntity.AccommodationEntityBuilder accommodationEntity = AccommodationEntity.builder();

        accommodationEntity.city( cityMapper.toEntity( accommodation.getCity() ) );
        accommodationEntity.id( accommodation.getId() );
        accommodationEntity.title( accommodation.getTitle() );
        accommodationEntity.description( accommodation.getDescription() );
        accommodationEntity.address( accommodation.getAddress() );
        accommodationEntity.price( accommodation.getPrice() );
        accommodationEntity.rating( accommodation.getRating() );
        accommodationEntity.capacity( accommodation.getCapacity() );
        accommodationEntity.pictureUrl( accommodation.getPictureUrl() );

        return accommodationEntity.build();
    }

    @Override
    public List<Accommodation> toDtoList(List<AccommodationEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<Accommodation> list = new ArrayList<Accommodation>( entityList.size() );
        for ( AccommodationEntity accommodationEntity : entityList ) {
            list.add( toDto( accommodationEntity ) );
        }

        return list;
    }
}
