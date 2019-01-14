package com.rakuten.fullstackrecruitmenttest.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rakuten.fullstackrecruitmenttest.dto.EmployeeDto;
import com.rakuten.fullstackrecruitmenttest.dto.ResponseDto;
import com.rakuten.fullstackrecruitmenttest.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class MainController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseDto create(@RequestParam("file") MultipartFile file) {
		ResponseDto responseDto = null;
		try {
			String completeData = new String(file.getBytes());
			responseDto = employeeService.create(completeData);
		} catch (IOException e) {
			return new ResponseDto("ERROR: File Not Found");
		} catch (Exception e) {
			return new ResponseDto("ERROR: " + e.getMessage());
		}
		return responseDto;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public ResponseDto edit(@RequestBody EmployeeDto employeeDto) {
		ResponseDto responseDto = null;
		try {
			System.out.println("employeeDto.getId: "+employeeDto.getId());
			responseDto = employeeService.edit(employeeDto);
		} catch (Exception e) {
			return new ResponseDto("ERROR: " + e.getMessage());
		}
		return responseDto;
	}

}
