package com.example.vaccineNation.Controller;

import com.example.vaccineNation.Enum.VaccineBrand;
import com.example.vaccineNation.Exception.PatientNotFoundException;
import com.example.vaccineNation.Model.Dose;
import com.example.vaccineNation.Service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")
public class DoseController {

    @Autowired
    DoseService doseService;
    @PostMapping("/vaccine")
    public Dose addDose(@RequestParam("id") int patientId,
                        @RequestParam("brand") VaccineBrand vaccineBrand) throws PatientNotFoundException {
       return doseService.addDose(patientId,vaccineBrand);

    }
}
