package com.lucasms.pontoIntelignete.api.repositories;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Base64Utils;

import com.lucasms.pontointeligente.api.PontoInteligneteApplication;
import com.lucasms.pontointeligente.api.enums.ProfileEnums;
import com.lucasms.pontointeligente.api.repositories.CompanyRepository;
import com.lucasms.pontointeligente.api.repositories.EmployeeRepository;
import com.lucasms.pontointeligente.api.repository.entities.Company;
import com.lucasms.pontointeligente.api.repository.entities.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PontoInteligneteApplication.class)
@ActiveProfiles(value = "teste")

public class EmployeeRepositoryTest {
	private static final String CPF = "10303494904";

	private static final String CNPJ = "56789015101119";

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Before
	public void setEmployee() throws Exception {
		Employee employeeTest = employeeRepository.findByNumberCpf(CPF);

		if (!Optional.ofNullable(employeeTest).isPresent()) {
			employeeTest = creatEmployee();
		}
		employeeTest.setDateUpdate(LocalDateTime.now());
		employeeRepository.save(employeeTest);
	}

	@Test
	public void test() {
		Employee employeeTest = employeeRepository.findByNumberCpf(CPF);
		assertNotNull(employeeTest);
	}

	private Employee creatEmployee() {
		Employee employee = new Employee();
		employee.setNameEmployee("Funcionario de Teste Silva 2");
		employee.setNumberCpf(CPF);
		employee.setEmailFunc("emailFunctest@testemail.com");
		employee.setPassword(Base64Utils.encodeToString("12345678".getBytes()));
		employee.setTypeProfile(ProfileEnums.ROLE_USER);
		Company companyTest = companyRepository.findByNumberCnpj(CNPJ);
		employee.setCompany(companyTest);
		
		return employee;
	}
}
