package com.lucasms.pontointeligente.api.repository.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lucasms.pontointeligente.api.enums.ProfileEnums;

@Entity
@Table(name = "funcionario")
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static Logger logger = LoggerFactory.getLogger(Employee.class);

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_funcionario")
	private Long id;
	
	@Column(name="nm_funcionario", nullable = false)
	private String nameEmployee;
	
	@Column(name="email", nullable = false)
	private String emailFunc;
	
	@Column(name="senha", nullable = false)
	private String password;
	
	@Column(name="nr_cpf", nullable = false)
	private String numberCpf;

	@Column(name="vlHora")
	private BigDecimal timeValue;
	
	@Column(name="qt_hr_trab_dia")
	private BigDecimal amountHoursWorkedDay;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tp_perfil", nullable = false)
	private ProfileEnums typeProfile;

	@Column(name="dt_criacao")
	private LocalDateTime dateCriation;
	
	@Column(name="dt_atualizacao")
	private LocalDateTime dateUpdate;

	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "id_empresa")
	private Company company;

	@OneToMany(mappedBy = "employee", targetEntity = Timekeeping.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Timekeeping> timekeeping;

	public Employee() {
		setDateUpdate(LocalDateTime.now());
		setDateCriation(LocalDateTime.now());

	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameEmployee() {
		return nameEmployee;
	}

	public void setNameEmployee(String nameEmployee) {
		this.nameEmployee = nameEmployee;
	}

	public String getEmailFunc() {
		return emailFunc;
	}

	public void setEmailFunc(String emailFunc) {
		this.emailFunc = emailFunc;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumberCpf() {
		return numberCpf;
	}

	public void setNumberCpf(String numberCpf) {
		this.numberCpf = numberCpf;
	}

	public BigDecimal getTimeValue() {
		return timeValue;
	}

	public void setTimeValue(BigDecimal timeValue) {
		this.timeValue = timeValue;
	}

	public BigDecimal getAmountHoursWorkedDay() {
		return amountHoursWorkedDay;
	}

	public void setAmountHoursWorkedDay(BigDecimal amountHoursWorkedDay) {
		this.amountHoursWorkedDay = amountHoursWorkedDay;
	}

	public ProfileEnums getTypeProfile() {
		return typeProfile;
	}

	public void setTypeProfile(ProfileEnums typeProfile) {
		this.typeProfile = typeProfile;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Timekeeping> getTimekeeping() {
		return timekeeping;
	}

	public void setTimekeeping(List<Timekeeping> timekeeping) {
		this.timekeeping = timekeeping;
	}
	
	public void writeLog() {
		logger.info("Funcionario [id = {} , nome = '{}' , CPF = {} ]", id, nameEmployee, numberCpf);
	}
}
