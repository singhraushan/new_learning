
package com.rakuten.fullstackrecruitmenttest.utility;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rakuten.fullstackrecruitmenttest.dto.EmployeeDto;
import com.rakuten.fullstackrecruitmenttest.service.impl.EmployeeServiceImpl;

/**
 * @author Raushan kumar
 *
 */
public class CsvReader {
	private static final Logger logger = LoggerFactory.getLogger(CsvReader.class);
	public static  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
//if csv file does not have header then please pass isHeader as false.
	public static Map<List<String>, List<EmployeeDto>> csvToEmmployeeBean(String fileData, String seperator,
			boolean isHeader) {
		logger.info("Csv to bean creation starting, isHeader: "+isHeader); 
		List<EmployeeDto> employeeDtoList = new ArrayList<EmployeeDto>();
		List<String> errorList = new ArrayList<String>();

		int rowCount = 0;
		String[] rows = fileData.split("\n");
		for (String row : rows) {
			++rowCount;
			if (isHeader) {
				isHeader = false;
				continue;
			}

			String[] columns = row.split(seperator);
			EmployeeDto employeeDto = new EmployeeDto();
			employeeDto.setName(columns[0].trim());
			employeeDto.setDepartment(columns[1].trim());
			employeeDto.setDesignation(columns[2].trim());
			employeeDto.setSalary(columns[3].trim());
			employeeDto.setJoiningDate(columns[4].trim());

			String result = isValid(employeeDto);
			if (result == null)
				employeeDtoList.add(employeeDto);
			else
				errorList.add("Row Number: " + rowCount + " has error:" + result);
		}
		Map<List<String>, List<EmployeeDto>> map = new HashMap<List<String>, List<EmployeeDto>>();
		map.put(errorList, employeeDtoList);
		logger.info("Exiting csvToEmmployeeBean() method"); 
		return map;
	}
//validating the employee details
	private static String isValid(EmployeeDto employeeDto) {

		if (!Pattern.matches("[a-zA-Z]+", employeeDto.getName()))
			return "Invalid Name";

		if (!Pattern.matches("[a-zA-Z0-9-_*]+", employeeDto.getDepartment()))
			return "Invalid Department";

		if (!(employeeDto.getDesignation().equalsIgnoreCase("Developer")
				|| employeeDto.getDesignation().equalsIgnoreCase("Senior Developer")
				|| employeeDto.getDesignation().equalsIgnoreCase("Manager")
				|| employeeDto.getDesignation().equalsIgnoreCase("Team Lead")
				|| employeeDto.getDesignation().equalsIgnoreCase("VP")
				|| employeeDto.getDesignation().equalsIgnoreCase("CEO")))
			return "Invalid Designation";

		try {
			Double.parseDouble(employeeDto.getSalary());
		} catch (Exception e) {
			return "Invalid Salary";
		}

		try {
			sdf.parse(employeeDto.getJoiningDate());
		} catch (Exception e) {
			return "Invalid Date";
		}
		return null;
	}

}
