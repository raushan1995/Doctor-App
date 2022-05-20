package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.model.Doctor;

@Service
public interface DoctorService  {
	
	//post mapping
	public Doctor addDoctor(Doctor doctor);
	//get mapping
	public List<Doctor> getAllDoctors();
	//delete mapping
	public void deleteDoctorBydoctorid(int doctorid);
    //put mapping
	public Doctor updateDoctor(Doctor doctor);

}
