package com.lucasms.pontointeligente.api.repository.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "empresa")
public class Company implements Serializable{
	
	private static final Logger logger = LoggerFactory.getLogger(Company.class);

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_empresa")
	private Long id;
	
	@Column(name="razao_social", nullable = false)
	private String socialReason;
	
	@Column(name="nr_cnpj", nullable = false)
	private String numberCnpj;
	
	@Column(name="dt_criacao")
	private LocalDateTime dateCriation;
	
	@Column(name="dt_atualizacao")
	private LocalDateTime dateUpdate;
	
	@OneToMany(mappedBy = "company", targetEntity = Employee.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Employee> employee;

	public Company(){
		setDateUpdate(LocalDateTime.now());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSocialReason() {
		return socialReason;
	}

	public void setSocialReason(String socialReason) {
		this.socialReason = socialReason;
	}

	public String getNumberCnpj() {
		return numberCnpj;
	}

	public void setNumberCnpj(String numberCnpj) {
		this.numberCnpj = numberCnpj;
	}

	public LocalDateTime getDateCriation() {
		return dateCriation;
	}

	public void setDateCriation(LocalDateTime dateCriation) {
		this.dateCriation = dateCriation;
	}

	public LocalDateTime getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(LocalDateTime dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	
	public void writeLog() {
	   logger.info("Empresa [id = {} , razão social = '{}' , CNPJ = {} ]", id, socialReason, numberCnpj);
	}
}
