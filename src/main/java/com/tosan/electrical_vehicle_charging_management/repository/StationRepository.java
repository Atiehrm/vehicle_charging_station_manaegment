package com.tosan.electrical_vehicle_charging_management.repository;

import com.tosan.electrical_vehicle_charging_management.data.entity.Station;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

/**
 * @author arm
 */
@Repository
public interface StationRepository {

    Optional<Station> findByName(String name);

    Set<Station> findAll();

    @Transactional
    @Modifying
    @Query(value = "update Station s set s.name=:name where s.id =:id")
    boolean update(@Param("id") long id, @Param("name") String name);

    Station findStationsByLatitudeAndLongitude(double latitude, double longitude);
}
