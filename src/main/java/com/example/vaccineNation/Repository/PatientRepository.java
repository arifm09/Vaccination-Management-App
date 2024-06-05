package com.example.vaccineNation.Repository;

import com.example.vaccineNation.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {

}
