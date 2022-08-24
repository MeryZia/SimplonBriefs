package com.example.EmpMgtSpring.Controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.EmpMgtSpring.Model.Employee;
import com.example.EmpMgtSpring.Repository.RepositoryEmployee;

@RestController
public class ControllerEmployee {	

	 @Autowired
		private RepositoryEmployee eRepo;
		
		@GetMapping({"/list", "/"})
		public ModelAndView getAllEmployees() {
			ModelAndView mav = new ModelAndView("EmployeeList");
			mav.addObject("employees", eRepo.findAll());
			return mav;
		}
		
		@GetMapping("/addEmployeeForm")
		public ModelAndView addEmployeeForm() {
			ModelAndView mav = new ModelAndView("AddEmployee");
			Employee newEmployee = new Employee();
			mav.addObject("employee", newEmployee);
			return mav;
		}
		
		@PostMapping("/saveEmployee")
		public String saveEmployee(@ModelAttribute Employee employee) {
			eRepo.save(employee);
			return "redirect:/list";
		}
		
		@GetMapping("/showUpdateForm")
		public ModelAndView showUpdateForm(@RequestParam Long employeeId) {
			ModelAndView mav = new ModelAndView("AddEmployee");
			Employee employee = eRepo.findById(employeeId).get();
			mav.addObject("employee", employee);
			return mav;
		}
		
		@GetMapping("/deleteEmployee")
		public String deleteEmployee(@RequestParam Long employeeId) {
			eRepo.deleteById(employeeId);
			return "redirect:/list";
		}
		
		 @GetMapping("/403")
		 public String error403() {
			 return "403";
		 }
		 
		 @GetMapping("/login")
		 public String loginPage() {
			 return "login";
		 }
}
