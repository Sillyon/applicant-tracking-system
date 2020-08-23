package com.fiz.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tr_aday01")
public class Applicant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADAY_ID")
	private Integer id;

	@Column(name = "AD", length = 40)
	private String name;

	@Column(name = "SOYAD", length = 40)
	private String surname;

	@Column(name = "NOT")
	private String desciption;

	@Temporal(TemporalType.DATE)
	@Column(name = "DOGUM_TARIHI")
	private Date birth;

	public void setName(String name) {
		this.name = name.toLowerCase();
	}

	public void setSurname(String surname) {
		this.surname = surname.toLowerCase();
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption.toLowerCase();
	}

}
