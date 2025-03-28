package fr.training.booki.repository;

import fr.training.booki.entity.AccommodationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository extends JpaRepository<AccommodationEntity, Long> {

    @Query("SELECT a FROM AccommodationEntity a WHERE a.city.name = :cityName")
    List<AccommodationEntity> findByCityName(@Param("cityName") String cityName);
}
