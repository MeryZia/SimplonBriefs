package com.example.EmpMgtSpring.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="employee")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "firstname")
  private String firstName;
  
  @Column(name = "lastname")
  private String lastName;
  
  @Column(name="salary")
	private double salary;
  
  @Column(name="post")
	private String post;
  
  @Column(name="contractType")
	private String contractType;

public long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public double getSalary() {
	return salary;
}

public void setSalary(double salary) {
	this.salary = salary;
}

public String getPost() {
	return post;
}

public void setPost(String post) {
	this.post = post;
}

public String getContractType() {
	return contractType;
}

public void setContractType(String contractType) {
	this.contractType = contractType;
}

public Employee() {
	super();
}

public Employee(Long id, String firstName, String lastName, double salary, String post, String contractType) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.salary = salary;
	this.post = post;
	this.contractType = contractType;
}

public Employee(String firstName, String lastName, double salary, String post, String contractType) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.salary = salary;
	this.post = post;
	this.contractType = contractType;
}

@Override
public String toString() {
	return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
			+ ", post=" + post + ", contractType=" + contractType + "]";
}
 
}
