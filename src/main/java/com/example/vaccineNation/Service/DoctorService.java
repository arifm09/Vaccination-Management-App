package com.example.vaccineNation.Service;

import com.example.vaccineNation.Exception.DoctorNotFoundException;
import com.example.vaccineNation.Exception.PatientNotFoundException;
import com.example.vaccineNation.Model.Appointment;
import com.example.vaccineNation.Model.Doctor;
import com.example.vaccineNation.Model.Patient;
import com.example.vaccineNation.Repository.AppointmentRepository;
import com.example.vaccineNation.Repository.DoctorRepository;
import com.example.vaccineNation.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.vaccineNation.Enum.AppointmentStatus.BOOKED;


@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    AppointmentRepository appointmentRepository;
    public void addDoctor(Doctor doctor) {

        doctorRepository.save(doctor);
    }

    public Doctor getDoctor(int id) throws DoctorNotFoundException {

        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if(doctorOptional.isEmpty()){
            throw new DoctorNotFoundException("Invalid Id");
        }
        Doctor doctor = doctorOptional.get();
//        Doctor doctor = doctorRepository.findById(id);  // wrong statement
        return doctor;
    }


}
