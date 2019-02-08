package com.lucasms.pontointeligente.api.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "apontamento_horas")
public class Timekeeping implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(Employee.class);

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_apontamento")
	private Long id;
	
	@Column(name="data_apontada")
	private LocalDateTime dateTimekeeping;
	
	@Column(name="descricao")
	private String description;
	
	@Column(name="localizacao")
	private String location;
	
	@Column(name="data_criacao")
	private LocalDateTime dateCriation;
	
	@Column(name="data_atualizacao")
	private LocalDateTime dateUpdate;
	
	@ManyToMany(fetch= FetchType.EAGER)
	private Employee employee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateTimekeeping() {
		return dateTimekeeping;
	}

	public void setDateTimekeeping(LocalDateTime dateTimekeeping) {
		this.dateTimekeeping = dateTimekeeping;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public void writeLog() {
		logger.info("Ponto [id = {} , Data apontada = {} , localizacao= '{}']", id, dateTimekeeping, location);
	}
}
