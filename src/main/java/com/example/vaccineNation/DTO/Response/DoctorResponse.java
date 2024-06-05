package com.example.vaccineNation.DTO.Response;

import com.example.vaccineNation.Enum.Gender;
import com.example.vaccineNation.Enum.Specialization;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DoctorResponse {
    private String name;
    private Gender gender;
    private Specialization specialization;

}
