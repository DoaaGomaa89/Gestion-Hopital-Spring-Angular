package com.example.demo.Controller;

import com.example.demo.Entities.Doctor;
import com.example.demo.Entities.Patient;
import com.example.demo.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService doctorService;
    @Autowired
    public DoctorController(DoctorService doctorService) {this.doctorService = doctorService;}

    // Endpoint to add a new patient (accessible to ADMIN role)
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }
    // Endpoint to get all patients (accessible to USER and ADMIN roles)
    @GetMapping("/showall")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<Doctor> getAllDoctors() {
        return doctorService.showall();
    }

    // Endpoint to get a patient by ID (accessible to USER and ADMIN roles)
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorbyId(id);
    }

    // Endpoint to delete a patient by ID (accessible to ADMIN role)
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteDoctorById(@PathVariable Long id) {
        doctorService.deleteDoctorById(id);
    }

    // Endpoint to update a patient by ID (accessible to ADMIN role)
    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Doctor updateDoctorById(@PathVariable Long id, @RequestBody Doctor doctor) {
        return doctorService.updateDoctorById(id, doctor);
    }
}
