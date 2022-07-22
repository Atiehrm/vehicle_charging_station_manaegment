package com.tosan.electrical_vehicle_charging_management.service;

import com.tosan.electrical_vehicle_charging_management.data.entity.Station;
import com.tosan.electrical_vehicle_charging_management.dto.StationDto;

import java.util.Set;

/**
 * @author arm
 */
public class StationServiceImpl implements StationService{
    @Override
    public boolean save(StationDto stationDto) {
        return false;
    }

    @Override
    public boolean delete(StationDto stationDto) {
        return false;
    }

    @Override
    public boolean update(StationDto stationDto) {
        return false;
    }

    @Override
    public Set<Station> stationsInformation() {
        return null;
    }

    @Override
    public Station singleStationInformation(String name) {
        return null;
    }

    @Override
    public Set<Station> getAroundStations(double latitue, double longitude, double distance) {
        return null;
    }
}
