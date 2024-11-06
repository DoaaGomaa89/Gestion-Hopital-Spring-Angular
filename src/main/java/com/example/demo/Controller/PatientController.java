package com.example.demo.Controller;

import com.example.demo.Entities.Patient;
import com.example.demo.Entities.Doctor;
import com.example.demo.Service.PatientService;
import com.example.demo.Service.DoctorService;
import com.example.demo.DTO.PatientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@CrossOrigin("*")
public class PatientController {

    private final PatientService patientService;
    private final DoctorService doctorService;

    @Autowired
    public PatientController(PatientService patientService, DoctorService doctorService) {
        this.patientService = patientService;
        this.doctorService = doctorService;
    }

    // Endpoint to add a new patient (accessible to ADMIN role)
    @PostMapping("/add")
   // @PreAuthorize("hasRole('ADMIN')")
    public Patient addPatient(@RequestBody PatientRequest patientRequest) {
        // Retrieve the doctor by ID from the request
        Doctor doctor = doctorService.getDoctorbyId(patientRequest.getDoctorId());

        // Create a new Patient object and set its properties
        Patient patient = new Patient();
        patient.setNom(patientRequest.getNom());
        patient.setDateNaissane(patientRequest.getDateNaissane());
        patient.setMalade(patientRequest.isMalade());
        patient.setScore(patientRequest.getScore());
        patient.setDoctor(doctor); // Set the Doctor in the Patient

        return patientService.addPatient(patient); // Save and return the new Patient
    }

    // Other methods remain unchanged
    @GetMapping("")
   // @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<Patient> getAllPatients() {
        return patientService.showall();
    }

    @GetMapping("/{id}")
   // @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientbyId(id);
    }

    @DeleteMapping("/delete/{id}")
   // @PreAuthorize("hasRole('ADMIN')")
    public void deletePatientById(@PathVariable Long id) {
        patientService.deletePatientById(id);
    }

    @PutMapping("/update/{id}")
   //  @PreAuthorize("hasRole('ADMIN')")
    public Patient updatePatientById(@PathVariable Long id, @RequestBody Patient patient) {
        return patientService.updatePatientById(id, patient);
    }
}
