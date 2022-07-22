package com.tosan.electrical_vehicle_charging_management.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

/**
 * @author arm
 */
@Getter
@Setter
public class ApiErrorDto {
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy hh:mm:ss")
    private Date timeStamp;
    private String message;
    private List<String> validationErrors;

    public ApiErrorDto(HttpStatus status, String message, List<String> validationErrors) {
        timeStamp = new Date();
        this.status = status;
        this.message = message;
        this.validationErrors = validationErrors;
    }
}
