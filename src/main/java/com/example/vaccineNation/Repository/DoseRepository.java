package com.example.vaccineNation.Repository;

import com.example.vaccineNation.Model.Dose;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoseRepository extends JpaRepository<Dose,Integer> {

}
