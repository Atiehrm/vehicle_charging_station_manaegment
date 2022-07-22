package com.tosan.electrical_vehicle_charging_management.repository;

import com.tosan.electrical_vehicle_charging_management.data.entity.ParentCompany;
import com.tosan.electrical_vehicle_charging_management.data.entity.Station;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

/**
 * @author arm
 */
@Repository
public interface CompanyRepository extends CrudRepository<ParentCompany, Long> {
    Optional<ParentCompany> findByName(String name);

    @Transactional
    @Modifying
    @Query(value = "update ParentCompany p set p.name=:name where p.id =:id")
    boolean update(@Param("id") long id, @Param("name") String name);

    Set<ParentCompany> findAll();

    @Transactional
    @Modifying
    @Query("select ParentCompany.stationSet from ParentCompany p join fetch p.branch where p.name=:name ")
    Set<Station> findAllStations(@Param("name") String name);
}
