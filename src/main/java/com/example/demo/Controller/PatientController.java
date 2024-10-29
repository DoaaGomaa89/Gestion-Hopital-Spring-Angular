package com.example.demo.Controller;

import com.example.demo.Entities.Patient;
import com.example.demo.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // Endpoint to add a new patient (accessible to ADMIN role)
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    // Endpoint to get all patients (accessible to USER and ADMIN roles)
    @GetMapping("/showall")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<Patient> getAllPatients() {
        return patientService.showall();
    }

    // Endpoint to get a patient by ID (accessible to USER and ADMIN roles)
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientbyId(id);
    }

    // Endpoint to delete a patient by ID (accessible to ADMIN role)
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deletePatientById(@PathVariable Long id) {
        patientService.deletePatientById(id);
    }

    // Endpoint to update a patient by ID (accessible to ADMIN role)
    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Patient updatePatientById(@PathVariable Long id, @RequestBody Patient patient) {
        return patientService.updatePatientById(id, patient);
    }
}
