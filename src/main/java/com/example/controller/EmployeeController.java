package com.example.controller;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.EmployeeDetails;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	SessionFactory sessionFactory;

	@RequestMapping(value = "/empSave", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> empSave(@RequestParam("empName") String empName,
			@RequestParam("EmpAddress") String EmpAddress, @RequestParam("salary") int salary,
			@RequestParam("ContactNo") int ContactNo) {

		EmployeeDetails empInfo=new EmployeeDetails();
		empInfo.setEmpName(empName);
		empInfo.setEmpAddress(EmpAddress);
		empInfo.setSalary(salary);
		empInfo.setContactNo(ContactNo);

		employeeService.saveEmployee(empInfo);

		return new ResponseEntity<String>("Record Inserted Successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET)
	public List<EmployeeDetails> getAllEmployee() {
		List<EmployeeDetails> empList = employeeService.searchAllEmployee();
		return empList;

	}

	@RequestMapping(value = "/findEmployee", method = RequestMethod.GET)
	public EmployeeDetails findEmployee(@RequestParam("empId") Long empId) {
		EmployeeDetails emp = employeeService.searchEmployee(empId);
		return emp;
	}

	@RequestMapping(value = "/existEmployee", method = RequestMethod.GET)
	public boolean existEmployee(@RequestParam("empId") Long empId) {
		boolean result = employeeService.existEmployee(empId);
		return result;
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public void deleteEmployee(@RequestParam("empId") Long empId) {
		employeeService.deleteEmployee(empId);
	}

	@RequestMapping(value = "/deleteAllEmployee", method = RequestMethod.GET)
	public void deleteAllEmployee() {
		employeeService.deleteAllEmployee();
	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT)
	public ResponseEntity<String> updateEmployee(@RequestParam("empId") Long empId,
			@RequestBody EmployeeDetails details) {
		EmployeeDetails availId = employeeService.searchEmployee(empId);
		if (availId == null) {
			System.out.println("Employee does not exits");
			return new ResponseEntity<String>("Employee does not exits", HttpStatus.NOT_FOUND);
		}
		availId.setEmpName(details.getEmpName());
		availId.setEmpAddress(details.getEmpAddress());
		availId.setSalary(details.getSalary());
		availId.setContactNo(details.getContactNo());

		employeeService.saveEmployee(availId);
		return new ResponseEntity<String>("Record updated Successfully", HttpStatus.CREATED);
	}

}
