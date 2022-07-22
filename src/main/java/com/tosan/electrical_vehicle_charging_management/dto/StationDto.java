package com.tosan.electrical_vehicle_charging_management.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author arm
 */
@Builder
@Data
public class StationDto {
    private String name;
    private double latitude;
    private double longitude;
    private ParentCompanyDto parentCompanyDto;
}
