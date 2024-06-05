package com.example.vaccineNation.Model;

import com.example.vaccineNation.Enum.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Column(unique = true,nullable = false)
    private String emailId;

    private boolean vaccinated;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;
}
