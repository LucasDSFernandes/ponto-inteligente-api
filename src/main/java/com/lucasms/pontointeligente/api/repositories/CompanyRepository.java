package com.lucasms.pontointeligente.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lucasms.pontointeligente.api.repository.entities.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

	Company findByNumberCnpj(String cnpj);

}
