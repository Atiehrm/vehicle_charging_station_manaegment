package com.tosan.electrical_vehicle_charging_management.web;

import com.tosan.electrical_vehicle_charging_management.data.entity.ParentCompany;
import com.tosan.electrical_vehicle_charging_management.dto.ApiErrorDto;
import com.tosan.electrical_vehicle_charging_management.dto.ParentCompanyDto;
import com.tosan.electrical_vehicle_charging_management.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author arm
 */
@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
@Api(value = "CompanyRestController")
public class CompanyRestController {
    private final CompanyService companyService;

    @ApiOperation(value = "Get list of Company info ", response = Iterable.class, tags = "getCompanyInfos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "validation error!"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @GetMapping(value = "/AllCompaniesInfo"
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<ParentCompanyDto>> getAllCompaniesInfo() {
        Set<ParentCompanyDto> dtos = companyService.getCompaniesInformation();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "validation error!"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @PutMapping(value = "/SingleCompanyInfo", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ParentCompanyDto> getSingleCompanyInfo(@RequestBody ParentCompanyDto parentCompanyDto) {
        return new ResponseEntity<>(parentCompanyDto, HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "validation error!",response = ApiErrorDto.class),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @PostMapping(value = "/addCompany", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveNewCompany(@RequestBody ParentCompanyDto parentCompanyDto) {
        companyService.save(parentCompanyDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "validation error!"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @PostMapping(value = "/deleteCompany", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteCompany(@RequestBody ParentCompanyDto parentCompanyDto) {
        companyService.delete(parentCompanyDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "validation error!"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @PutMapping(value = "/updateCompany", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateCompany(@RequestBody ParentCompanyDto parentCompanyDto) {
        companyService.update(parentCompanyDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
