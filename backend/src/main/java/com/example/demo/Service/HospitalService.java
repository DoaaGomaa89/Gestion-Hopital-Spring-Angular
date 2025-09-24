package com.example.demo.Service;

import com.example.demo.DAOs.HospitalRepository;
import com.example.demo.Entities.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;
    @Autowired
    public HospitalService(HospitalRepository hospitalRepository) {this.hospitalRepository = hospitalRepository;}

   public Hospital AddHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
   }
   public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
   }
   public Hospital getHospitalById(Long id) {return hospitalRepository.findById(id).get();}



}
