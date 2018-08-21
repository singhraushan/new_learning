package com.rau.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rau.crud.dto.EmployeeDto;
import com.rau.crud.service.EmployeeService;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	public EmployeeController() {
		System.out.println("Constructor of EmployeeController");
	}
	
	@RequestMapping(value="/")//by default method=RequestMethod.GET
	public ModelAndView employeeList() {
		System.out.println(" start of employeeList of EmployeeController");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("listEmployee", employeeService.getEmployeeList());
		modelAndView.setViewName("home");
		System.out.println(" end of employeeList of EmployeeController");
		return modelAndView;
	}
	
	@RequestMapping(value="newEmployee",method=RequestMethod.GET)
	public ModelAndView newEmployee() {//can keep 'ModelAndView modelAndView' in argument and use modelAndView.
		ModelAndView mv = new ModelAndView();
		mv.addObject("newEmp", new EmployeeDto());
		mv.setViewName("employeeRegistry");
		return mv;
	}
	
	@RequestMapping(value="/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute EmployeeDto EmployeeDto) {
		if(EmployeeDto.getId()==0)
		     employeeService.addEmployee(EmployeeDto);
		else
			employeeService.updateEmployee(EmployeeDto);
		return new ModelAndView("redirect:/");
	}
	
	
}
