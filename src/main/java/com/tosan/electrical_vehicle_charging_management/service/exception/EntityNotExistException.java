package com.tosan.electrical_vehicle_charging_management.service.exception;

/**
 * @author arm
 */
public class EntityNotExistException extends RuntimeException {
    public EntityNotExistException(String message) {
        super(message);
    }
}
