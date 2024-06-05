package com.example.vaccineNation.Controller;

import com.example.vaccineNation.DTO.Response.AppointmentResponse;
import com.example.vaccineNation.Exception.DoctorNotFoundException;
import com.example.vaccineNation.Model.Appointment;
import com.example.vaccineNation.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;
    @PostMapping("/booked")
    public ResponseEntity addAppointment(@RequestParam("doctorId") int doctorId, @RequestParam("patientId") int patientId) throws DoctorNotFoundException {
        try {
            AppointmentResponse appointmentResponse = appointmentService.addAppointment(doctorId, patientId);
            return new ResponseEntity(appointmentResponse, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/completed")
    public ResponseEntity addToCompleteAppointment(@RequestParam("doctorId") int doctorId, @RequestParam("patientId") int patientId) throws DoctorNotFoundException {
        try {
            AppointmentResponse appointmentResponse = appointmentService.addToAppointment(doctorId, patientId);
            return new ResponseEntity(appointmentResponse, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
