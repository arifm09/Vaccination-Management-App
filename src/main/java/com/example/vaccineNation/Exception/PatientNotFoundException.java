package com.example.vaccineNation.Exception;

public class PatientNotFoundException extends RuntimeException{
   public PatientNotFoundException(String message){
       super(message);
   }
}
