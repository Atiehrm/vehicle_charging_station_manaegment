package com.tosan.electrical_vehicle_charging_management.web;

import com.tosan.electrical_vehicle_charging_management.data.entity.Station;
import com.tosan.electrical_vehicle_charging_management.dto.StationDto;
import com.tosan.electrical_vehicle_charging_management.service.StationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author arm
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/station")
public class StationRestController {
    private final StationService stationService;

    @ApiOperation(value = "Get list of Station info ", response = Iterable.class, tags = "getStationInfos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "validation error!"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @GetMapping(value = "/AllStationsInfo"
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<StationDto>> getAllStationsInfo
            (@RequestBody StationDto dto) {
        return new ResponseEntity(stationService.stationsInformation(), HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "validation error!"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @GetMapping(value = "/singleStationInfo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StationDto> getSingleCompanyInfo(@RequestBody StationDto dto) {
        return new ResponseEntity(stationService.singleStationInformation(dto.getName()), HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "validation error!"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @PostMapping(value = "/addStation", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveNewStation(@RequestBody StationDto dto) {
        stationService.save(dto);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "validation error!"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @PostMapping(value = "/deleteStation", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStation(@RequestBody StationDto dto) {
        stationService.delete(dto);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "validation error!"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @PutMapping(value = "/updateStation", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStation(@RequestBody StationDto dto) {
        stationService.update(dto);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "validation error!"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @PutMapping(value = "/getAroundstation", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Set<Station> getAroundStations(@RequestBody StationDto dto) {
        return stationService.getAroundStations(dto.getLatitude(), dto.getLongitude(), 23);
    }
}
