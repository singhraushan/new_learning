
package com.rakuten.fullstackrecruitmenttest.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rakuten.fullstackrecruitmenttest.dto.EmployeeDto;
import com.rakuten.fullstackrecruitmenttest.dto.ResponseDto;
import com.rakuten.fullstackrecruitmenttest.model.Employee;
import com.rakuten.fullstackrecruitmenttest.repo.EmployeeRepository;
import com.rakuten.fullstackrecruitmenttest.service.EmployeeService;
import com.rakuten.fullstackrecruitmenttest.utility.CsvReader;

/**
 * @author Raushan kumar
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Value("${input.csv.isHeader}")
	private String isHeader;
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public ResponseDto create(String csvData) {
		logger.info("Entering into create() methed "); 
		
		//Assuming column header is there in the file(if not then change input.csv.isHeader value from application.properties file). If column header there in the file then pass true else false
		Map<List<String>, List<EmployeeDto>> resultMap = CsvReader.csvToEmmployeeBean(csvData, ",", Boolean.parseBoolean(isHeader)); 
		
		List<EmployeeDto> employeeDtos = null;
		List<String> errors = null;

		Set<List<String>> keys = resultMap.keySet();
		for (List<String> key : keys) {
			employeeDtos = resultMap.get(key);
			errors = key;
			break;
		}

		List<Employee> employeeList = dtoToEntity(employeeDtos);
		employeeRepository.saveAll(employeeList);
		if (errors.size() == 0) {
			logger.info("Exiting create() methed"); 
			return new ResponseDto("Success");
		} else {
			ResponseDto responseDto = new ResponseDto("Error");
			responseDto.setError(errors);
			logger.error("Exiting create() methed  with error"); 
			return responseDto;
		}
		
	}

	@Override
	public ResponseDto edit(EmployeeDto employeeDto) {
		logger.info("Entering into edit() methed "); 
		if (employeeDto.getId() != 0) {
			employeeRepository.saveAndFlush(dtoToEntity(employeeDto));
			logger.info("Exiting edit() methed "); 
			return new ResponseDto("INFO: Success");
		} else {
			logger.info("Exiting edit() methed "); 
			return new ResponseDto("ERROR: Employee data not present in DB");
		}
	}
	
	private Employee dtoToEntity(EmployeeDto employeeDto) {
		logger.info("Dto to entity conversion started!"); 
			Employee emp = new Employee();
			emp.setId(employeeDto.getId());
			emp.setName(employeeDto.getName());
			emp.setDepartment(employeeDto.getDepartment());
			emp.setDesignation(employeeDto.getDesignation());
			emp.setSalary(Double.parseDouble(employeeDto.getSalary()));
			try {
				emp.setJoiningDate(CsvReader.sdf.parse(employeeDto.getJoiningDate()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			logger.info("Dto to entity conversion ended!"); 
			return emp;
	}
	
	private List<Employee> dtoToEntity(List<EmployeeDto> employeeDtos) {
		logger.info("Dto to entity conversion started!"); 
		List<Employee> employees = new ArrayList<Employee>();
		for (EmployeeDto employeeDto : employeeDtos) {

			Employee emp = new Employee();
			emp.setName(employeeDto.getName());
			emp.setDepartment(employeeDto.getDepartment());
			emp.setDesignation(employeeDto.getDesignation());
			emp.setSalary(Double.parseDouble(employeeDto.getSalary()));
			try {
				emp.setJoiningDate(CsvReader.sdf.parse(employeeDto.getJoiningDate()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			employees.add(emp);
		}
		logger.info("Dto to entity conversion ended!"); 
		return employees;
	}
}
