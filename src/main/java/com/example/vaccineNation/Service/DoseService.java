package com.example.vaccineNation.Service;

import com.example.vaccineNation.Enum.VaccineBrand;
import com.example.vaccineNation.Exception.PatientNotFoundException;
import com.example.vaccineNation.Model.Dose;
import com.example.vaccineNation.Model.Patient;
import com.example.vaccineNation.Repository.DoseRepository;
import com.example.vaccineNation.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {
    @Autowired
    DoseRepository doseRepository;

    @Autowired
    PatientRepository patientRepository;


    public Dose addDose(int patientId, VaccineBrand vaccineBrand) throws PatientNotFoundException {
         Optional<Patient> patientOptional = patientRepository.findById(patientId);

         if(patientOptional.isEmpty()){
             throw new PatientNotFoundException("Invalid patient");
         }
         Patient patient = patientOptional.get();

         if(patient.isVaccinated()){
             throw new RuntimeException("Patient is already vaccinated");
         }

         patient.setVaccinated(true);

         Dose dose = new Dose();

         dose.setSerialNumber(String.valueOf(UUID.randomUUID()));
         dose.setVaccineBrand(vaccineBrand);
         dose.setPatient(patient);

         patientRepository.save(patient);
         doseRepository.save(dose);

         return dose;
    }
}
