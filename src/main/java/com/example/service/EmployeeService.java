package com.example.service;

import java.util.List;

import com.example.model.EmployeeDetails;

public interface EmployeeService {

	public EmployeeDetails saveEmployee(EmployeeDetails details);

	public EmployeeDetails searchEmployee(Long id);

	public List<EmployeeDetails> searchAllEmployee();

	public void deleteEmployee(Long id);

	public void deleteAllEmployee();

	public boolean existEmployee(Long id);

}
