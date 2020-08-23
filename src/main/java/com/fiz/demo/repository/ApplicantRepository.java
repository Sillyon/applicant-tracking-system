package com.fiz.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiz.demo.entity.Applicant;

@Repository
public interface ApplicantRepository extends CrudRepository<Applicant, Integer> {

}
