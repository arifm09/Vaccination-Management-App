package com.example.vaccineNation.DTO.Response;

import com.example.vaccineNation.Enum.AppointmentStatus;
import com.example.vaccineNation.Model.Doctor;
import com.example.vaccineNation.Model.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AppointmentResponse {
    private Date date;
    private AppointmentStatus status;
    private String doctorName;
    private PatientResponse patientResponse;
}
