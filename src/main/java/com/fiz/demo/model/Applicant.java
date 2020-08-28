package com.fiz.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`tr_aday01`")
public class Applicant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "`ADAY_ID`")
	private Long id;

	@Column(name = "`AD`", length = 40)
	private String name;

	@Column(name = "`SOYAD`", length = 40)
	private String surname;

	@Column(name = "`NOT`")
	private String description;

	@Column(name = "`DOGUM_TARIHI`")
	private Date birth;

	// TODO enum düzenlenecek.
	@Column(name = "`GORUSME_DURUM`")
	private Status status;

	public void setName(String name) {
		this.name = name.toLowerCase();
	}

	public void setSurname(String surname) {
		this.surname = surname.toLowerCase();
	}

	public void setDescription(String description) {
		this.description = description.toLowerCase();
	}

}
