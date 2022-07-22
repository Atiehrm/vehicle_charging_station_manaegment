package com.tosan.electrical_vehicle_charging_management.dto.mapper;

import com.tosan.electrical_vehicle_charging_management.data.entity.Station;
import com.tosan.electrical_vehicle_charging_management.dto.StationDto;
import org.springframework.stereotype.Component;

/**
 * @author arm
 */
@Component
public class StationMapper {
    public Station toStation(StationDto stationDto) {
        return Station.builder().name("").build();
    }

    public StationDto toStationDto(Station station){
        return StationDto.builder().name("").build();
    }
}
