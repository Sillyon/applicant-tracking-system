package com.fiz.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiz.demo.model.Applicant;
import com.fiz.demo.repo.ApplicantRepository;

@RequestMapping
@RestController
@CrossOrigin(origins = "*")
public class ApplicantController {

	private final ApplicantRepository repository;

	public ApplicantController(ApplicantRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public Iterable<Applicant> getAllApplicants(){
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Applicant getApplicantById(@PathVariable Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	@PostMapping
	public Applicant addApplicant(@RequestBody Applicant applicant) {
		return repository.save(applicant);
	}
	
	/*@DeleteMapping("/{id}")
	public Applicant deleteApplicant(@PathVariable Integer id) {
		return repository.deleteById(id);
	}*/

}
