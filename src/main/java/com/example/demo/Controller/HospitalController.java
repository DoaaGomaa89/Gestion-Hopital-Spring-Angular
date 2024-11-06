package com.example.demo.Controller;

import com.example.demo.Entities.Hospital;
import com.example.demo.Service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/hospitals")
public class HospitalController {
    private final HospitalService hospitalService;
    @Autowired
    public HospitalController(HospitalService hospitalService) {this.hospitalService = hospitalService;}
    @PostMapping("/add")
    public Hospital addnew(@RequestBody Hospital hospital){
        return hospitalService.AddHospital(hospital);
    }
    @GetMapping("")
    public List<Hospital> getAll(){
        return hospitalService.getAllHospitals();
    }
}
