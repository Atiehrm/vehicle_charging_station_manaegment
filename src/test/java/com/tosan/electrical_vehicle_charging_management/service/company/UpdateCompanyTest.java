package com.tosan.electrical_vehicle_charging_management.service.company;

import com.tosan.electrical_vehicle_charging_management.dto.ParentCompanyDto;
import com.tosan.electrical_vehicle_charging_management.service.CompanyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.jsp.jstl.core.Config;

/**
 * @author arm
 */
public class UpdateCompanyTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    CompanyService companyService = context.getBean(CompanyService.class);
    ParentCompanyDto parentCompany;
    ParentCompanyDto parentCompany1;

    @BeforeEach
    public void init() {
        parentCompany = ParentCompanyDto.builder().build();
        parentCompany1 = ParentCompanyDto.builder().build();

    }

    @Test
    void givenExistCompany_WhenUpdateCompanyCalls_ThenReturnTrueResponse() {
        boolean result = companyService.update(parentCompany);
        Assertions.assertTrue(result);
    }

    @Test
    void givenNotExistCompany_WhenUpdateCompanyCalls_ThenReturnFalseResponse() {
        boolean result = companyService.update(parentCompany1);
        Assertions.assertFalse(result);
    }
}
