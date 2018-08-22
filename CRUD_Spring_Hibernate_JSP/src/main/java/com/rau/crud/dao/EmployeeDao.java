package com.rau.crud.dao;

import java.util.List;

import com.rau.crud.dto.EmployeeDto;
import com.rau.crud.entity.Employee;

public interface EmployeeDao {
	public void addEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public List<Employee> getEmployeeList();
	public Employee getEmployeeById(int id);
	public void deleteEmployeeById(int id);
}
