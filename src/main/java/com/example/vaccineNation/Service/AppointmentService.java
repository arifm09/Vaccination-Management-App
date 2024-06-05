package com.example.vaccineNation.Service;

import com.example.vaccineNation.DTO.Response.AppointmentResponse;
import com.example.vaccineNation.DTO.Response.DoctorResponse;
import com.example.vaccineNation.DTO.Response.PatientResponse;
import com.example.vaccineNation.Enum.AppointmentStatus;
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

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.example.vaccineNation.Enum.AppointmentStatus.BOOKED;

@Service
public class AppointmentService {
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    public AppointmentResponse addAppointment(int doctorId, int patientId) throws DoctorNotFoundException {
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);
        Optional<Patient> patientOptional = patientRepository.findById(patientId);

        if(doctorOptional.isEmpty()){
            throw new DoctorNotFoundException("Invalid doctorId");
        }

        if(patientOptional.isEmpty()){
            throw new PatientNotFoundException("Invalid patientId");
        }

        Doctor doctor = doctorOptional.get();
        Patient patient = patientOptional.get();

        Appointment appointment = new Appointment();

        appointment.setStatus(AppointmentStatus.BOOKED);
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setAppontmentId(String.valueOf(UUID.randomUUID()));
        appointmentRepository.save(appointment);

        AppointmentResponse appointmentResponse = new AppointmentResponse();

        appointmentResponse.setStatus(appointment.getStatus());
        appointmentResponse.setDate(appointment.getDateOfAppoinment());

        PatientResponse patientResponse = new PatientResponse();
         patientResponse.setName(patient.getName());
         patientResponse.setVaccinated(patient.isVaccinated());

        DoctorResponse doctorResponse = new DoctorResponse();
        doctorResponse.setName(doctor.getName());
        doctorResponse.setSpecialization(doctor.getSpecialization());

        appointmentResponse.setPatientResponse(patientResponse);
        appointmentResponse.setDoctorName(appointment.getDoctor().getName());

        return appointmentResponse;
    }

    public AppointmentResponse addToAppointment(int doctorId, int patientId) throws DoctorNotFoundException {
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);
        Optional<Patient> patientOptional = patientRepository.findById(patientId);

        if(doctorOptional.isEmpty()){
            throw new DoctorNotFoundException("Invalid doctorId");
        }

        if(patientOptional.isEmpty()){
            throw new PatientNotFoundException("Invalid patientId");
        }

        Doctor doctor = doctorOptional.get();
        Patient patient = patientOptional.get();

        List<Appointment> appointments = appointmentRepository.findAll();
        AppointmentResponse appointmentResponse = new AppointmentResponse();
        for(Appointment appointment: appointments) {
            if(appointment.getPatient().getId()==patientId && appointment.getPatient().getId()==doctorId ){
                appointment.setStatus(AppointmentStatus.COMPLETED);
                appointmentRepository.save(appointment);
                appointmentResponse.setDoctorName(appointment.getDoctor().getName());
                appointmentResponse.setStatus(AppointmentStatus.COMPLETED);
                appointmentResponse.setDate(appointment.getDateOfAppoinment());

                PatientResponse patientResponse = new PatientResponse();

                patientResponse.setVaccinated(appointment.getPatient().isVaccinated());
                patientResponse.setName(appointment.getPatient().getName());

                appointmentResponse.setPatientResponse(patientResponse);

            }
        }

        return appointmentResponse;
    }
}







