package com.fiz.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiz.demo.model.Applicant;
import com.fiz.demo.repo.ApplicantRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ApplicantController {

	@Autowired
	private ApplicantRepository repository;

	@GetMapping("/applicants")
	public List<Applicant> getAllApplicants() {
		List<Applicant> applicants = new ArrayList<>();
		repository.findAll().forEach(applicants::add);
		return applicants;
	}

	@GetMapping("/applicant/{id}")
	public Applicant getApplicantById(@PathVariable Long id) {
		return repository.findById(id).orElse(null);
	}

	@PostMapping("/applicant")
	public Applicant postApplicant(@RequestBody Applicant applicant) {
		return repository.save(applicant);
	}

	@DeleteMapping("/applicant/{id}")
	public ResponseEntity<String> deleteApplicant(@PathVariable Long id) {
		repository.deleteById(id);
		return new ResponseEntity<>("Applicant has been deleted!", HttpStatus.OK);
	}

	@PutMapping("/applicant/{id}")
	public ResponseEntity<Applicant> updateApplicant(@PathVariable Long id, @RequestBody Applicant applicant) {
		Optional<Applicant> applicantData = repository.findById(id);

		if (applicantData.isPresent()) {
			Applicant _applicant = applicantData.get();
			_applicant.setName(applicant.getName());
			_applicant.setSurname(applicant.getSurname());
			_applicant.setDesciption(applicant.getDesciption());
			_applicant.setBirth(applicant.getBirth());
			// TODO GORUSME_DURUM eklenecek.
			return new ResponseEntity<>(repository.save(_applicant), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
