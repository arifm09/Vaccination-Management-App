package com.example.vaccineNation.Controller;

import com.example.vaccineNation.DTO.Request.PatientRequest;
import com.example.vaccineNation.DTO.Response.PatientResponse;
import com.example.vaccineNation.Exception.PatientNotFoundException;
import com.example.vaccineNation.Model.Patient;
import com.example.vaccineNation.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.vaccineNation.Enum.Gender;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/add")
    public ResponseEntity addPatient(@RequestBody PatientRequest patientRequest){

        try{
            patientService.addPatient(patientRequest);
            return new ResponseEntity( "Patient has been added successfully", HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity("Invalid Patient",HttpStatus.NOT_ACCEPTABLE);
        }
    }


    @GetMapping("/get")
    public ResponseEntity getPatient(@RequestParam("id") int id) throws PatientNotFoundException {

        try {
            PatientResponse patientResponse = patientService.getPatient(id);
            return new ResponseEntity(patientResponse,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity("Patient not found",HttpStatus.NOT_FOUND);
        }
    }


//     Get all the patients of male/female
    @GetMapping("/get/gender/{gender}")
    public List<PatientResponse> getAllPatientsOfSpecificGender(@PathVariable("gender") Gender gender){
        return patientService.getAllPatientOfSpecificGender(gender);
    }

    @GetMapping("/get/vaccinated")
    public List<PatientResponse> getVaccinatedPatients(){
        return patientService.getVaccinatedPatients();
    }

    @GetMapping("/change/vaccinatedStatus")
    public List<PatientResponse> changeVaccinatedStatus(){
        return patientService.changedVaccinatedStatus();
    }
}

