package com.tosan.electrical_vehicle_charging_management.service;

import com.tosan.electrical_vehicle_charging_management.data.entity.Station;
import com.tosan.electrical_vehicle_charging_management.dto.StationDto;
import com.tosan.electrical_vehicle_charging_management.dto.mapper.StationMapper;
import com.tosan.electrical_vehicle_charging_management.repository.StationRepository;
import com.tosan.electrical_vehicle_charging_management.service.exception.EntityIsExistException;
import com.tosan.electrical_vehicle_charging_management.service.exception.EntityNotExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author arm
 */
@Service
@AllArgsConstructor
public class StationServiceImpl implements StationService {
    private StationRepository stationRepository;
    private final StationMapper stationMapper;

    @Override
    public boolean save(StationDto stationDto) {
        Station station1 = stationMapper.toStation(stationDto);
        Optional<Station> foundedStation = stationRepository.findByName(station1.getName());
        if (foundedStation.isPresent()) {
            throw new EntityIsExistException("station name not exist!");
        } else {
            stationRepository.save(station1);
            return true;
        }
    }

    @Override
    public boolean delete(StationDto stationDto) {
        Station station1 = stationMapper.toStation(stationDto);
        Optional<Station> foundedStation = stationRepository.findByName(station1.getName());
        if (foundedStation.isEmpty()) {
            throw new EntityNotExistException("station exist!");
        } else {
            stationRepository.delete(station1);
            return true;
        }
    }

    @Override
    public boolean update(StationDto stationDto) {
        Station station1 = stationMapper.toStation(stationDto);
        Optional<Station> foundedStation = stationRepository.findByName(station1.getName());
        if (foundedStation.isPresent()) {
            stationRepository.update(station1.getId(), station1.getName());
            return true;
        } else throw new EntityNotExistException("station not exist");
    }

    @Override
    public Set<StationDto> stationsInformation() {
        Set<StationDto> stationDtos = new HashSet<>();
        Set<Station> stations = stationRepository.findAll();
        for (Station s : stations) {
            StationDto stationDto = stationMapper.toStationDto(s);
            stationDtos.add(stationDto);
        }
        return stationDtos;
    }

    @Override
    public Station singleStationInformation(String name) {
        Optional<Station> station = stationRepository.findByName(name);
        return station.orElseThrow(() -> new EntityNotExistException("station not exist!"));
    }

    @Override
    public Set<Station> getAroundStations(double latitude, double longitude) {
        Map<Station, Double> stationDistances = new HashMap<>();
        Set<Station> stationSet = stationRepository.findAll();
        for (Station s : stationSet) {
            double distance = calculateDistance(s, latitude, longitude);
            stationDistances.put(s, distance);
        }

        Set<Station> topFiveStations =
                stationDistances.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                        .limit(5)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toSet());
        return topFiveStations;
    }

    public double calculateDistance(Station station, double latitude, double longitude) {
        double theta = station.getLongitude() - longitude;
        double dist = Math.sin(deg2rad(station.getLatitude())) * Math.sin(deg2rad(latitude))
                + Math.cos(deg2rad(station.getLatitude())) * Math.cos(deg2rad(latitude))
                * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;
        return dist;
    }

    double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}