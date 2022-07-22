package com.tosan.electrical_vehicle_charging_management.dto.mapper;

import com.tosan.electrical_vehicle_charging_management.data.entity.ParentCompany;
import com.tosan.electrical_vehicle_charging_management.dto.ParentCompanyDto;
import org.springframework.stereotype.Component;

/**
 * @author arm
 */
@Component

public class CompanyMapper {
    public ParentCompany toParentCompany(ParentCompanyDto parentCompanyDto) {
        return ParentCompany.builder().name("").build();
    }

    public ParentCompanyDto toParentCompanyDto(ParentCompany ParentCompany) {
        return ParentCompanyDto.builder().name("").build();
    }
}
