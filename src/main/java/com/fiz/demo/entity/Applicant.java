package com.fiz.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

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
	@Column(name = "ADAY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "AD", length = 40)
	private String name;

	@Column(name = "SOYAD", length = 40)
	private String surname;

	@Column(name = "NOT")
	private String desciption;

	@Column()
	@Temporal(TemporalType.DATE)
	private Date birth;

}
