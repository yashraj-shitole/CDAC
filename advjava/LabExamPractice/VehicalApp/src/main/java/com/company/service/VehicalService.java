package com.company.service;

import java.time.LocalDate;
import java.util.List;

import com.company.dto.ApiResponse;
import com.company.dto.VehicalDTO;
import com.company.pojo.Vehical;

public interface VehicalService {

	ApiResponse addVehical(VehicalDTO entity);

	ApiResponse deleteVehical(String username);

	List<RespUserDto> getUserByDate(LocalDate date);

	List<Vehical> getAllVehical();

}
