package com.example.demo.Controller;

import com.example.demo.Entities.Doctor;
import com.example.demo.Entities.Hospital;
import com.example.demo.Service.DoctorService;
import com.example.demo.Service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/hospitals")
public class HospitalController {
    private final DoctorService doctorService;
    private final HospitalService hospitalService;
    @Autowired
    public HospitalController(HospitalService hospitalService , DoctorService doctorService) {this.hospitalService = hospitalService;this.doctorService = doctorService;}
    @PostMapping("/add")
    public Hospital addnew(@RequestBody Hospital hospital){
        return hospitalService.AddHospital(hospital);
    }
    @GetMapping("")
    public List<Hospital> getAll(){
        return hospitalService.getAllHospitals();
    }
    @GetMapping("/{id}")
    public Hospital getHospital(@PathVariable Long id){
        return hospitalService.getHospitalById(id);
    }
    // Get all the doctor by the hospital_id
    @GetMapping("{id}/doctors")
    public List<Doctor> getDoctors(@PathVariable Long id){
        return doctorService.listAllDoctorByHospitalId(id);
    }
}
