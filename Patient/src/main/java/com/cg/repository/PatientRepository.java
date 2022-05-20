package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.Patient;
@Repository
public interface PatientRepository extends MongoRepository<Patient, Integer> {

}
