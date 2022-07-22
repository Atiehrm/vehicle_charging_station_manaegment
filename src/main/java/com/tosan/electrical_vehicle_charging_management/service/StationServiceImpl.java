package com.tosan.electrical_vehicle_charging_management.service;

import com.tosan.electrical_vehicle_charging_management.data.entity.Station;
import com.tosan.electrical_vehicle_charging_management.dto.StationDto;
import com.tosan.electrical_vehicle_charging_management.dto.mapper.StationMapper;
import com.tosan.electrical_vehicle_charging_management.repository.StationRepository;
import com.tosan.electrical_vehicle_charging_management.service.exception.EntityIsExistException;
import com.tosan.electrical_vehicle_charging_management.service.exception.EntityNotExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

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
    public Set<Station> stationsInformation() {
        return stationRepository.findAll();
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
