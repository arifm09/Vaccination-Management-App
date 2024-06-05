package com.example.vaccineNation.Model;

import com.example.vaccineNation.Enum.VaccineBrand;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import com.example.vaccineNation.Model.Patient;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Dose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String serialNumber; // UUID

    @Enumerated(value = EnumType.STRING)
    private VaccineBrand vaccineBrand;


    @CreationTimestamp
    private Date dateOfVaccination;

    @OneToOne
    @JoinColumn
    Patient patient;
}
