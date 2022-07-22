package com.tosan.electrical_vehicle_charging_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author arm
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StationDto {
    private Long Id;
    private String name;
    private double latitude;
    private double longitude;
    private ParentCompanyDto parentCompanyDto;
}
