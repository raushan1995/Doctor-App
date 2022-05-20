package com.cg.service;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import com.cg.model.Patient;
import com.cg.repository.PatientRepository;


@SpringBootTest
@ExtendWith(MockitoExtension.class)

class PatientServiceTest {

	//repository
		@Mock
		private PatientRepository repository;
		@InjectMocks
		private PatientServiceImpl psl;
		

		@Test
		public void TestAddPatient() throws FileAlreadyExistsException {
			Patient p1= new Patient(1,"ram","patna","pain"); //user input
			when(repository.save(any())).thenReturn(p1);
			psl.addPatient(p1); //data is saved in database
			verify(repository,times(1)).save(any());
		}
		@Test
		public void testGetAllPatients() {
			Patient p1=new Patient(10,"ram","Chennai","heart"); //user input
			Patient p2=new Patient(20,"Sales","Mumbai","pain"); //user input
			Patient p3=new Patient(30,"Admin","Delhi","heart"); //user input
			repository.save(p1);
			repository.save(p2);
			repository.save(p3); //saved in database
			
			List<Patient>pList=new ArrayList<>(); //creating List Object
			pList.add(p1);
			pList.add(p2);
			pList.add(p3);
			
			when(repository.findAll()).thenReturn(pList);
			List<Patient> pList1 = psl.getAllPatients();
			assertEquals(pList,pList1);
			verify(repository,times(1)).save(p1);
			verify(repository,times(1)).findAll();
			
		}
		
		@Test
		public void TestDeleteBypatientid() {
			repository.deleteById(10);
			}

}
