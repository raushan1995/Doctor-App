package com.cg.service;

import java.util.List;

import com.cg.model.Patient;



public interface PatientService {

	
	//post mapping
		public Patient addPatient(Patient patient);
		//get mapping
		public List<Patient> getAllPatients();
		//delete mapping
		public void deletePatientBypatientid(int patientid);
	    //put mapping
		public Patient updatePatient(Patient patient);
}
