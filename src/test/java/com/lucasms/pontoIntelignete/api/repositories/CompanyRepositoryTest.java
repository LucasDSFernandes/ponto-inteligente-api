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

import com.lucasms.pontointeligente.api.PontoInteligneteApplication;
import com.lucasms.pontointeligente.api.repositories.CompanyRepository;
import com.lucasms.pontointeligente.api.repository.entities.Company;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PontoInteligneteApplication.class)
@ActiveProfiles(value="teste")
public class CompanyRepositoryTest {
	private static final String NM_EMPRESA_TESTE = "Empresa Teste ltda";
	private static final String CNPJ = "56789015101119";

	@Autowired
	private CompanyRepository companyRepository;

	@Before
	public void setUp() throws Exception {
		Company companyTest = companyRepository.findByNumberCnpj(CNPJ);
		if (!Optional.ofNullable(companyTest).isPresent()) {
			companyTest = createCompany();
		}
		companyRepository.save(companyTest);
	}

	private Company createCompany() {
		Company company = new Company();
		company.setSocialReason(NM_EMPRESA_TESTE);
		company.setNumberCnpj(CNPJ);
		return company;
	}

	@Test
	public void test() {
		Company companyTest = companyRepository.findByNumberCnpj(CNPJ);
		assertNotNull(companyTest);
	}

}
