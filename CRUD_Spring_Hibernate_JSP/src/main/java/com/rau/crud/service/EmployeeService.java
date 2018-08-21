package com.rau.crud.service;

import java.util.List;

import com.rau.crud.dto.EmployeeDto;

public interface EmployeeService {

	public void addEmployee(EmployeeDto employeeDto);
	public void updateEmployee(EmployeeDto employeeDto);
	public List<EmployeeDto> getEmployeeList();

}
