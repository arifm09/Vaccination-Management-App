package com.example.vaccineNation.Repository;

import com.example.vaccineNation.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

}
