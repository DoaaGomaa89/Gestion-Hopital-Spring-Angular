package com.example.demo.Controller;

import com.example.demo.DTO.DoctorRequest;
import com.example.demo.Entities.Doctor;
import com.example.demo.Entities.Hospital;
import com.example.demo.Entities.Patient;
import com.example.demo.Service.DoctorService;
import com.example.demo.Service.HospitalService;
import com.example.demo.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@CrossOrigin("*")
public class DoctorController {
    private final DoctorService doctorService;
    private final HospitalService hospitalService;
    //private final PatientService patientService;
    @Autowired
    public DoctorController(DoctorService doctorService,HospitalService hospitalService ) {
        this.doctorService = doctorService;
        this.hospitalService=hospitalService;
    }

    // Endpoint to add a new patient (accessible to ADMIN role)
    @PostMapping("/add")
   // @PreAuthorize("hasRole('ADMIN')")
    public Doctor addDoctor(@RequestBody DoctorRequest doctor) {
        Hospital hospital = hospitalService.getHospitalById(doctor.getHospitalId());
        Doctor doctor1 = new Doctor();
        doctor1.setNom(doctor.getNom());
        doctor1.setSpecialite(doctor.getSpecialite());
        doctor1.setDateNaissane(doctor.getDateNaissane());
        doctor1.setHospital(hospital);
        return doctorService.addDoctor(doctor1);
    }
    // Endpoint to get all patients (accessible to USER and ADMIN roles)
    @GetMapping("")
    //@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<Doctor> getAllDoctors() {
        return doctorService.showall();
    }

    // Endpoint to get a patient by ID (accessible to USER and ADMIN roles)
    @GetMapping("/{id}")
    //@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorbyId(id);
    }

    // Endpoint to delete a patient by ID (accessible to ADMIN role)
    @DeleteMapping("/delete/{id}")
   // @PreAuthorize("hasRole('ADMIN')")
    public void deleteDoctorById(@PathVariable Long id) {
        doctorService.deleteDoctorById(id);
    }

    // Endpoint to update a patient by ID (accessible to ADMIN role)
    @PutMapping("/update/{id}")
   // @PreAuthorize("hasRole('ADMIN')")
    public Doctor updateDoctorById(@PathVariable Long id, @RequestBody Doctor doctor) {
        return doctorService.updateDoctorById(id, doctor);
    }
}
