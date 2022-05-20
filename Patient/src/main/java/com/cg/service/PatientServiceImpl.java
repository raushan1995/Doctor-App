package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import com.cg.model.Patient;
import com.cg.repository.PatientRepository;


public class PatientServiceImpl  implements PatientService{

	private PatientRepository repository;

	@Autowired
	public PatientServiceImpl(PatientRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Patient addPatient(Patient patient) {
		// TODO Auto-generated method stub
		Patient savedPatient = repository.save(patient);
		return savedPatient;
	}

	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return (List<Patient>) repository.findAll();
	}

	@Override
	public void deletePatientBypatientid(int Id) {
		// TODO Auto-generated method stub
		repository.deleteById(Id);
	}

	@Override
	public Patient updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		Patient record;
		Optional<Patient> opt=repository.findById(patient.getId());
		if(opt.isPresent()) {
			record=opt.get();
			record.setId(patient.getId());
			record.setName(patient.getName());
			record.setAddress(patient.getAddress());
			record.setProblem(patient.getProblem());
			repository.save(record);
		}else {
			return new Patient();
		}
		return record;
	}
	

	


}
