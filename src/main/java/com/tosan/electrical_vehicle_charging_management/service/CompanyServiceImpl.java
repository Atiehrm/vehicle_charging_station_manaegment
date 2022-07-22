package com.tosan.electrical_vehicle_charging_management.service;

import com.tosan.electrical_vehicle_charging_management.data.entity.ParentCompany;
import com.tosan.electrical_vehicle_charging_management.data.entity.Station;
import com.tosan.electrical_vehicle_charging_management.dto.ParentCompanyDto;
import com.tosan.electrical_vehicle_charging_management.dto.mapper.CompanyMapper;
import com.tosan.electrical_vehicle_charging_management.repository.CompanyRepository;
import com.tosan.electrical_vehicle_charging_management.service.exception.EntityIsExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * @author arm
 */
@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService{
    private final CompanyMapper companyMapper;
    private final CompanyRepository companyRepository;
    @Override
    public boolean save(ParentCompanyDto parentCompanyDto) {
        ParentCompany parentCompany1 = companyMapper.toParentCompany(parentCompanyDto);
        Optional<ParentCompany> foundedCompany = companyRepository.findByName(parentCompany1.getName());
        if (foundedCompany.isPresent()) {
            throw new EntityIsExistException("this company name exist!");
        } else {
            companyRepository.save(parentCompany1);
            return true;
        }
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