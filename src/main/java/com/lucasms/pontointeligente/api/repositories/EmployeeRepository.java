package com.lucasms.pontointeligente.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lucasms.pontointeligente.api.repository.entities.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	Employee findByNumberCpf(String cpf);

}
