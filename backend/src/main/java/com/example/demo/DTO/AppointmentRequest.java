package com.example.demo.DTO;

import com.example.demo.Entities.Patient;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.util.Date;

@Data
public class AppointmentRequest {
    private String title;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date date;
    private Long patientId;
}
