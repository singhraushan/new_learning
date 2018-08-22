package com.rau.crud.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="/",method=RequestMethod.GET)//by default method=RequestMethod.GET
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
		mv.addObject("empDto", new EmployeeDto());
		mv.setViewName("employeeForm");
		return mv;
	}
	
	@RequestMapping(value="/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute EmployeeDto empDto) {
		System.out.println("save new Employee EmployeeDto.getId():"+empDto.getId());
		     employeeService.addEmployee(empDto);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/editEmployee/saveEmployee", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute EmployeeDto empDto) {
		System.out.println("updateEmployee EmployeeDto.getId():"+empDto.getId());
			employeeService.updateEmployee(empDto);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/editEmployee/{id}", method = RequestMethod.GET)
	public ModelAndView editEmployee(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("empDto", employeeService.getEmployeeById(id));
		modelAndView.setViewName("employeeForm");
		System.out.println("end of editEmployee");
		return modelAndView;
	}
	
	@RequestMapping(value="/deleteEmployee")//method= RequestMethod.POST doesn't work here
	public ModelAndView deleteEmployee(HttpServletRequest reuest) {
		int id = Integer.parseInt(reuest.getParameter("id"));
		employeeService.deleteEmployeeById(id);
		return new ModelAndView("redirect:/");
	}
	
	
}
