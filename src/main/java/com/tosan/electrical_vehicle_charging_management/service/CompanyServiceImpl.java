package com.tosan.electrical_vehicle_charging_management.service;

import com.tosan.electrical_vehicle_charging_management.data.entity.ParentCompany;
import com.tosan.electrical_vehicle_charging_management.data.entity.Station;
import com.tosan.electrical_vehicle_charging_management.dto.ParentCompanyDto;

import java.util.Set;

/**
 * @author arm
 */
public class CompanyServiceImpl implements CompanyService{
    @Override
    public boolean save(ParentCompanyDto parentCompanyDto) {
        return false;
    }

    @Override
    public boolean delete(ParentCompanyDto parentCompanyDto) {
        return false;
    }

    @Override
    public boolean update(ParentCompanyDto parentCompanyDto) {
        return false;
    }

    @Override
    public Set<ParentCompany> getCompaniesInformation() {
        return null;
    }

    @Override
    public ParentCompany findSingleCompanyByName(String name) {
        return null;
    }

    @Override
    public Set<Station> getAllStations(ParentCompanyDto parentCompanyDto) {
        return null;
    }
}
