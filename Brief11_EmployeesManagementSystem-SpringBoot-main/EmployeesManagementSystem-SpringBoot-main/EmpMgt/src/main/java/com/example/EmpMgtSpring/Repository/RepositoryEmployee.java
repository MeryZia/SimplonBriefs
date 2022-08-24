package com.example.EmpMgtSpring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmpMgtSpring.Model.Employee;


@Repository
public interface RepositoryEmployee extends JpaRepository<Employee,Long>{

}
