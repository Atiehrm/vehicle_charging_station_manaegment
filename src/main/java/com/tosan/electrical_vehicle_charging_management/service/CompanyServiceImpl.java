package com.tosan.electrical_vehicle_charging_management.service;

import com.tosan.electrical_vehicle_charging_management.data.entity.ParentCompany;
import com.tosan.electrical_vehicle_charging_management.data.entity.Station;
import com.tosan.electrical_vehicle_charging_management.dto.ParentCompanyDto;
import com.tosan.electrical_vehicle_charging_management.dto.StationDto;
import com.tosan.electrical_vehicle_charging_management.dto.mapper.CompanyMapper;
import com.tosan.electrical_vehicle_charging_management.dto.mapper.StationMapper;
import com.tosan.electrical_vehicle_charging_management.repository.CompanyRepository;
import com.tosan.electrical_vehicle_charging_management.service.exception.EntityIsExistException;
import com.tosan.electrical_vehicle_charging_management.service.exception.EntityNotExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author arm
 */
@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyMapper companyMapper;
    private final StationMapper stationMapper;
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
        ParentCompany parentCompany1 = companyMapper.toParentCompany(parentCompanyDto);
        Optional<ParentCompany> foundedCompany = companyRepository.findByName(parentCompany1.getName());
        if (foundedCompany.isEmpty()) {
            throw new EntityNotExistException("company not exist!");
        } else {
            companyRepository.delete(parentCompany1);
            return true;
        }
    }

    @Override
    public boolean update(ParentCompanyDto parentCompanyDto) {
        ParentCompany parentCompany1 = companyMapper.toParentCompany(parentCompanyDto);
        Optional<ParentCompany> foundedCompany = companyRepository.findByName(parentCompany1.getName());
        if (foundedCompany.isEmpty()) {
            throw new EntityNotExistException("company not exist!");
        } else {
            companyRepository.update(parentCompany1.getId(), parentCompany1.getName());
            return true;
        }
    }

    @Override
    public Set<ParentCompanyDto> getCompaniesInformation() {
        Set<ParentCompanyDto> parentCompanyDtos = new HashSet<>();
        Set<ParentCompany> parentCompanies = companyRepository.findAll();
        for (ParentCompany p : parentCompanies) {
            ParentCompanyDto companyDto = companyMapper.toParentCompanyDto(p);
            parentCompanyDtos.add(companyDto);
        }
        return parentCompanyDtos;
    }

    @Override
    public ParentCompany findSingleCompanyByName(String name) {
        Optional<ParentCompany> company = companyRepository.findByName(name);
        return company.orElseThrow(() -> new EntityNotExistException("company name not exist!"));
    }

    @Override
    public Set<StationDto> getAllStations(ParentCompanyDto parentCompanyDto) {
        Set<StationDto> stationDtos = new HashSet<>();
        ParentCompany parentCompany1 = companyMapper.toParentCompany(parentCompanyDto);
        Optional<ParentCompany> foundedCompany = companyRepository
                .findByName(parentCompany1.getName());
        if (foundedCompany.isEmpty()) {
            throw new EntityNotExistException("company not exist!");
        } else {
            Set<Station> stationSet = companyRepository.findAllStations(parentCompany1.getName());
            for (Station s : stationSet) {
                StationDto stationDto = stationMapper.toStationDto(s);
                stationDtos.add(stationDto);
            }
            return stationDtos;
        }
    }
}
