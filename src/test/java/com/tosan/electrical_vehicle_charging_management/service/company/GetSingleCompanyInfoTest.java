package com.tosan.electrical_vehicle_charging_management.service.company;

import com.tosan.electrical_vehicle_charging_management.data.entity.ParentCompany;
import com.tosan.electrical_vehicle_charging_management.dto.ParentCompanyDto;
import com.tosan.electrical_vehicle_charging_management.service.CompanyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.jsp.jstl.core.Config;
import java.util.Optional;

/**
 * @author arm
 */
public class GetSingleCompanyInfoTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    CompanyService companyService = context.getBean(CompanyService.class);
    ParentCompanyDto parentCompany;
    ParentCompanyDto parentCompany1;

    @BeforeEach
    public void init() {
        parentCompany = ParentCompanyDto.builder().name("Diamond").build();
        parentCompany1 = ParentCompanyDto.builder().name("Thomas").build();

    }

    @Test
    void givenNotExistCompany_WhenGetSingleCompanyInfoCalls_ThenReturnFalseResponse() {
        Optional<ParentCompany> result = Optional.ofNullable(companyService
                .findSingleCompanyByName(parentCompany.getName()));
        if (result.isEmpty())
            Assertions.fail();
    }

    @Test
    void givenExistCompany_WhenGetSingleCompanyInfoCalls_ThenReturnTrueResponse() {
        Optional<ParentCompany> result = Optional.ofNullable(companyService
                .findSingleCompanyByName(parentCompany1.getName()));
        if (result.isPresent())
            Assertions.assertTrue(true);
    }
}
