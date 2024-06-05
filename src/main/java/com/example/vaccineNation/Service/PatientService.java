package com.example.vaccineNation.Service;

import com.example.vaccineNation.DTO.Request.PatientRequest;
import com.example.vaccineNation.DTO.Response.PatientResponse;
import com.example.vaccineNation.Enum.Gender;
import com.example.vaccineNation.Exception.PatientNotFoundException;
import com.example.vaccineNation.Repository.PatientRepository;
import com.example.vaccineNation.Model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    public void addPatient(PatientRequest patientRequest) {
        Patient patient = new Patient();
        patient.setName(patientRequest.getName());
        patient.setAge(patientRequest.getAge());
        patient.setEmailId(patientRequest.getEmailId());
        patient.setGender(patientRequest.getGender());
        patient.setVaccinated(false);

        patientRepository.save(patient);

        PatientResponse patientResponse = new PatientResponse();

        patientResponse.setName(patient.getName());
        patientResponse.setVaccinated(patient.isVaccinated());


//       Patient savedPatient = patientRepository.save(patient);
//       return savedPatient;
    }

    public PatientResponse getPatient(int id) throws PatientNotFoundException {
          Optional<Patient> patientOptional = patientRepository.findById(id);

          if(patientOptional.isEmpty()){
              throw new PatientNotFoundException("Invalid Id");
          }


          Patient patient = patientOptional.get();

          PatientResponse patientResponse = new PatientResponse();

          patientResponse.setName(patient.getName());
          patientResponse.setVaccinated(patient.isVaccinated());

          return patientResponse;
    }
    public List<PatientResponse> getAllPatientOfSpecificGender(Gender gender){
       List<Patient> patients = patientRepository.findAll();

       List<PatientResponse> patientResponses = new ArrayList<>();

       for(Patient patient : patients){


           if(patient.getGender()==gender){
               PatientResponse patientResponse = new PatientResponse();
               patientResponse.setName(patient.getName());
               patientResponse.setVaccinated(patient.isVaccinated());

               patientResponses.add(patientResponse);
           }
       }
       return patientResponses;
    }

    public List<PatientResponse> getVaccinatedPatients() {
        List<Patient> patients = patientRepository.findAll();

        List<PatientResponse> patientResponses = new ArrayList<>();

        for(Patient patient: patients){


            if(patient.isVaccinated()==true && patient.getAge()>30){
                PatientResponse patientResponse = new PatientResponse();
                patientResponse.setName(patient.getName());
                patient.setVaccinated(patient.isVaccinated());

                patientResponses.add(patientResponse);
            }
        }
        return patientResponses;
    }

    public List<PatientResponse> changedVaccinatedStatus() {
        List<Patient> patients = patientRepository.findAll();

        List<PatientResponse> patientResponses = new ArrayList<>();

        for(Patient patient: patients){
                PatientResponse patientResponse = new PatientResponse();
                if(patient.isVaccinated()==true){
                    patient.setVaccinated(false);
                }
                else {
                    patient.setVaccinated(true);
                }
                patientResponse.setName(patient.getName());
                patientResponse.setVaccinated(patient.isVaccinated());

                patientRepository.save(patient);
                patientResponses.add(patientResponse);
        }
        return patientResponses;
    }
}
