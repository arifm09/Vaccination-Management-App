package com.example.vaccineNation.Model;
import com.example.vaccineNation.Enum.Gender;
import com.example.vaccineNation.Enum.Specialization;
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
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Enumerated(value = EnumType.STRING)
    private Specialization specialization;

}
