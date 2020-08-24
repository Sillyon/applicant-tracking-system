package com.fiz.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiz.demo.model.Applicant;

@Repository
public interface ApplicantRepository extends CrudRepository<Applicant, Long> {

	List<Applicant> findAllByName(String name);

}
