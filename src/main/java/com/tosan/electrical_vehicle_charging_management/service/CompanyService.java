package com.tosan.electrical_vehicle_charging_management.service;

import com.tosan.electrical_vehicle_charging_management.data.entity.ParentCompany;
import com.tosan.electrical_vehicle_charging_management.data.entity.Station;
import com.tosan.electrical_vehicle_charging_management.dto.ParentCompanyDto;
import com.tosan.electrical_vehicle_charging_management.dto.StationDto;

import java.util.Optional;
import java.util.Set;

/**
 * @author arm
 */
public interface CompanyService {
    boolean save(ParentCompanyDto parentCompanyDto);

    boolean delete(ParentCompanyDto parentCompanyDto);

    boolean update(ParentCompanyDto parentCompanyDto);

    Set<ParentCompanyDto> getCompaniesInformation();

    ParentCompany findSingleCompanyByName(String name);

    Set<StationDto> getAllStations(ParentCompanyDto parentCompanyDto);
}
