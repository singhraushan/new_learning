package com.rau.crud.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rau.crud.dao.EmployeeDao;
import com.rau.crud.dto.EmployeeDto;
import com.rau.crud.entity.Employee;
import com.rau.crud.service.EmployeeService;

@Transactional(readOnly = true) // without this Could not obtain
								// transaction-synchronized Session for current
								// thread
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public EmployeeServiceImpl() {
		System.out.println("Constructor of EmployeeServiceImpl");
	}

	/*
	 * @Transactional ( propagation = Propagation.REQUIRES_NEW )
	 * Propagation.REQUIRED is the default. Now what does REQUIRES_NEW do? The
	 * answer is two fold:
	 * 
	 * If there is no transaction currently open, open one. So it behaves
	 * exactly like REQUIRED in this case.
	 * 
	 * If there is an already existing transaction open, open up another one. So
	 * always execute in a new transaction. That means always open up/use
	 * another connection to the database!
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void addEmployee(EmployeeDto employeeDto) {
		List<EmployeeDto> employeeDtoList = new ArrayList<EmployeeDto>();
		employeeDtoList.add(employeeDto);
		employeeDao.addEmployee(toEntity(employeeDtoList).get(0));

	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void updateEmployee(EmployeeDto employeeDto) {
		List<EmployeeDto> employeeDtoList = new ArrayList<EmployeeDto>();
		employeeDtoList.add(employeeDto);
		employeeDao.updateEmployee(toEntity(employeeDtoList).get(0));
	}

	@Override
	public List<EmployeeDto> getEmployeeList() {
		return toDto(employeeDao.getEmployeeList());
	}

	private List<EmployeeDto> toDto(List<Employee> employeeList) {

		List<EmployeeDto> employeeDtoList = null;
		if (employeeList != null && !employeeList.isEmpty()) {
			employeeDtoList = new ArrayList<EmployeeDto>();
			for (Employee employee : employeeList) {
				if (employee != null) {
					EmployeeDto employeeDto = new EmployeeDto();
					employeeDto.setId(employee.getId());
					employeeDto.setName(employee.getName());
					employeeDto.setEmail(employee.getEmail());
					employeeDto.setTelephone(employee.getTelephone());
					employeeDto.setAddress(employee.getAddress());
					employeeDtoList.add(employeeDto);
				}
			}
		}
		return employeeDtoList;
	}

	private List<Employee> toEntity(List<EmployeeDto> employeeDtoList) {
		List<Employee> employeeList = null;
		if (employeeDtoList != null && !employeeDtoList.isEmpty()) {
			employeeList = new ArrayList<Employee>();
			for (EmployeeDto employeeDto : employeeDtoList) {
				if (employeeDto != null) {
					Employee employee = new Employee();
					employee.setId(employeeDto.getId());
					employee.setName(employeeDto.getName());
					employee.setEmail(employeeDto.getEmail());
					employee.setTelephone(employeeDto.getTelephone());
					employee.setAddress(employeeDto.getAddress());
					employeeList.add(employee);
				}
			}
		}
		return employeeList;
	}

}
