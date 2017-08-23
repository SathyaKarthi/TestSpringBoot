package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.model.EmployeeDetails;

public interface EmployeeRepository extends CrudRepository<EmployeeDetails, Long> {
	@SuppressWarnings("unchecked")
	public EmployeeDetails save(EmployeeDetails empDetails);

	public List<EmployeeDetails> findAll();

	public EmployeeDetails findOne(Long empId);

	public boolean exists(Long empId);

	public void delete(Long empId);
	
	public void deleteAll();
}
