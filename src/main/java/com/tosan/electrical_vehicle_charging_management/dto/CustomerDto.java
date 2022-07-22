package com.tosan.electrical_vehicle_charging_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author arm
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private String name;
    private double latitude;
    private double longitude;
}
