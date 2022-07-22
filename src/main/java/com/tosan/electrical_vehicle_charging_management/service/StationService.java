package com.tosan.electrical_vehicle_charging_management.service;

import com.tosan.electrical_vehicle_charging_management.data.entity.Station;
import com.tosan.electrical_vehicle_charging_management.dto.StationDto;

import java.util.Set;

/**
 * @author arm
 */
public interface StationService {
    boolean save(StationDto stationDto);

    boolean delete(StationDto stationDto);

    boolean update(StationDto stationDto);

    Set<Station> stationsInformation();

    Station singleStationInformation(String name);

    Set<Station> getAroundStations(double latitue, double longitude, double distance);
}
