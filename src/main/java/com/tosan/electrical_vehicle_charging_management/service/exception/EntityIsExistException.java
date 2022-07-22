package com.tosan.electrical_vehicle_charging_management.service.exception;

/**
 * @author arm
 */
public class EntityIsExistException extends RuntimeException {
    public EntityIsExistException(String message) {
        super(message);
    }
}
