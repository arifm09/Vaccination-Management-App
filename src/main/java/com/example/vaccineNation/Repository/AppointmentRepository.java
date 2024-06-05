package com.example.vaccineNation.Repository;

import com.example.vaccineNation.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
