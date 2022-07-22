package com.tosan.electrical_vehicle_charging_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * @author arm
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParentCompanyDto {
    private String name;
    private Set<ParentCompanyDto> branches = new HashSet<>();
    private Set<StationDto> stationSet = new HashSet<>();
}
