package com.example.vaccineNation.Controller;
import com.example.vaccineNation.Exception.DoctorNotFoundException;
import com.example.vaccineNation.Model.Appointment;
import com.example.vaccineNation.Service.DoctorService;
import com.example.vaccineNation.Model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController{
    @Autowired
    DoctorService doctorService;
    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor){
        doctorService.addDoctor(doctor);
        return "Doctor has been added successfully";
    }

    @GetMapping("/get")
    public Doctor getDoctor(@RequestParam("id") int id) throws DoctorNotFoundException {
        return doctorService.getDoctor(id);
    }


}


