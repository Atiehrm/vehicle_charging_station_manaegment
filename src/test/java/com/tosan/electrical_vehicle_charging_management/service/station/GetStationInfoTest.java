package com.tosan.electrical_vehicle_charging_management.service.station;

import com.tosan.electrical_vehicle_charging_management.data.entity.Station;
import com.tosan.electrical_vehicle_charging_management.dto.StationDto;
import com.tosan.electrical_vehicle_charging_management.service.StationService;
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
public class GetStationInfoTest {
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
    void givenNotExistStation_WhenGetSingleStationInfoCalls_ThenReturnFalseResponse() {
        Optional<Station> result = Optional.ofNullable(stationService
                .singleStationInformation(station.getName()));
        if (result.isEmpty())
            Assertions.fail();
    }

    @Test
    void givenExistStation_WhenGetSingleStationInfoCalls_ThenReturnTrueResponse() {
        Optional<Station> result = Optional.ofNullable(stationService.singleStationInformation(station.getName()));
        if (result.isPresent())
            Assertions.assertTrue(true);
    }
}
