package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.EmployeeDetails;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository testRepo;

	@Override
	public EmployeeDetails saveEmployee(EmployeeDetails details) {

		return testRepo.save(details);
	}

	@Override
	public EmployeeDetails searchEmployee(Long id) {

		return testRepo.findOne(id);
	}

	@Override
	public List<EmployeeDetails> searchAllEmployee() {

		return testRepo.findAll();
	}

	@Override
	public void deleteEmployee(Long id) {
		testRepo.delete(id);

	}

	@Override
	public void deleteAllEmployee() {
		testRepo.deleteAll();

	}

	@Override
	public boolean existEmployee(Long id) {
		return testRepo.exists(id);
	}

}
