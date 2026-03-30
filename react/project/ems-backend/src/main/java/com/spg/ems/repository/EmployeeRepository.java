package com.spg.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spg.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
