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
public class AddStationTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    StationService stationService = context.getBean(StationService.class);
    StationDto station;
    StationDto station1;

    @BeforeEach
    public void init() {
        station = StationDto.builder().name("E").latitude(245533).longitude(6757777).build();
        station1 = StationDto.builder().name("C").latitude(246663).longitude(67122333).build();

    }

    @Test
    void givenNotDuplicateStation_WhenAddNewStationCalls_ThenReturnTrueResponse() {
        boolean result = stationService.save(station);
        Assertions.assertTrue(result);
    }

    @Test
    void givenDuplicateStation_WhenAddNewStationCalls_ThenReturnTrueResponse() {
        boolean result = stationService.save(station1);
        Assertions.assertFalse(result);
    }
}
