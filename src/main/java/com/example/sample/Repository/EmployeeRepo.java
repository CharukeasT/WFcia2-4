package com.example.sample.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sample.Table.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer>{

}
