package com.cg.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.Doctor;



public interface DoctorRepository extends MongoRepository<Doctor, Integer> {

	
	

}
