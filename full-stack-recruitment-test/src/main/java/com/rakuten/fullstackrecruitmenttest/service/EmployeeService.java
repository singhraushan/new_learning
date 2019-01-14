package com.rakuten.fullstackrecruitmenttest.service;

import com.rakuten.fullstackrecruitmenttest.dto.EmployeeDto;
import com.rakuten.fullstackrecruitmenttest.dto.ResponseDto;

public interface EmployeeService {

	public ResponseDto create(String csvData);

	public ResponseDto edit(EmployeeDto employeeDto);

}
