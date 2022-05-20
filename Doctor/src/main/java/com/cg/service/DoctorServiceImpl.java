package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.model.Doctor;

import com.cg.repository.DoctorRepository;

public class DoctorServiceImpl  implements DoctorService{

    private DoctorRepository repository;
	
	@Autowired
	public DoctorServiceImpl(DoctorRepository repository) {
		super();
		this.repository = repository;
	}
	
	
	
	
	//post mapping
	@Override
	public Doctor addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
				Doctor savedDoctor = repository.save(doctor);
				return savedDoctor;
	}
   //get mapping
	@Override
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
				return (List<Doctor>) repository.findAll();
	}

	//put mapping
	@Override
	public Doctor updateDoctor(Doctor doctor) {
		Doctor record;
		Optional<Doctor> opt=repository.findById(doctor.getDoctorid());
		if(opt.isPresent()) {
			record=opt.get();
			record.setDoctorid(doctor.getDoctorid());
			record.setDoctorname(doctor.getDoctorname());
			record.setDoctoraddress(doctor.getDoctoraddress());
			repository.save(record);
		}else {
			return new Doctor();
		}
		return record;
	}
     //delete mapping
	@Override
	public void deleteDoctorBydoctorid(int doctorid) {
		// TODO Auto-generated method stub
		repository.deleteById(doctorid);
	}

}
