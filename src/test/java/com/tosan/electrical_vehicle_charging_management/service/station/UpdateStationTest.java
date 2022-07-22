package com.tosan.electrical_vehicle_charging_management.service.station;

import com.tosan.electrical_vehicle_charging_management.dto.StationDto;
import com.tosan.electrical_vehicle_charging_management.service.StationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.jsp.jstl.core.Config;

/**
 * @author arm
 */
public class UpdateStationTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    StationService stationService = context.getBean(StationService.class);
    StationDto station;
    StationDto station1;

    @BeforeEach
    public void init() {
        station = StationDto.builder().build();
        station1 = StationDto.builder().build();
    }

    @Test
    void givenExistStation_WhenUpdateStationCalls_ThenReturnTrueResponse() {
        boolean result = stationService.update(station);
        Assertions.assertTrue(result);
    }

    @Test
    void givenNotExistStation_WhenUpdateStationCalls_ThenReturnFalseResponse() {
        boolean result = stationService.update(station);
        Assertions.assertFalse(result);
    }
}
