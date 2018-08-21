package com.rau.crud.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rau.crud.dao.EmployeeDao;
import com.rau.crud.entity.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public EmployeeDaoImpl() {
		System.out.println("Constructor of EmployeeDaoImpl");
	}
	
	@Override
	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);

	}
	
	@Override
	public void updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);

	}

	@Override
	public List<Employee> getEmployeeList() {
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

}
