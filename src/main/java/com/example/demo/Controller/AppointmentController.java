package com.example.demo.Controller;

import com.example.demo.DTO.AppointmentRequest;
import com.example.demo.Entities.Appointment;
import com.example.demo.Entities.Patient;
import com.example.demo.Service.AppointmentService;
import com.example.demo.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final PatientService patientService;
    @Autowired
    public AppointmentController(AppointmentService appointmentService , PatientService patientService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
    }
    @PostMapping("/add")
   // @PreAuthorize("hasRole('ADMIN')")
    public Appointment addAppointment(@RequestBody AppointmentRequest appointment) {
        Patient p =  patientService.getPatientbyId(appointment.getPatientId());
        // Create a new Appointment object and set its properties
        Appointment appointment1 = new Appointment();
        appointment1.setDate(appointment.getDate());
        appointment1.setDescription(appointment.getDescription());
        appointment1.setTitle(appointment.getTitle());
        appointment1.setPatient(p);
        return appointmentService.addAppointment(appointment1);
    }

    @GetMapping("/all")
    //@PreAuthorize("hasRole('ADMIN')")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
   // @PreAuthorize("hasRole('ADMIN')")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    //Update an existing Appointment
    @PutMapping("/update/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public Appointment updateAppointment(@RequestBody AppointmentRequest appointment ,@PathVariable Long id) {
        Patient p =  patientService.getPatientbyId(appointment.getPatientId());
        Appointment appointment1 = appointmentService.getAppointmentById(id);
        appointment1.setDate(appointment.getDate());
        appointment1.setDescription(appointment.getDescription());
        appointment1.setTitle(appointment.getTitle());
        appointment1.setPatient(p);
        return appointmentService.updateAppointment(appointment1);
    }
}
