package com.example.demo.Service;


import com.example.demo.DAOs.DoctorRepository;
import com.example.demo.DAOs.PatientRepository;
import com.example.demo.Entities.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> showall() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorbyId(Long id) {
        return doctorRepository.findById(id).get();
    }

    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }

    public Doctor updateDoctorById(Long id,Doctor doctor) {
        Doctor d = doctorRepository.findById(id).get();
        d.setNom(doctor.getNom());
        d.setDateNaissane(doctor.getDateNaissane());
        d.setSpecialite(doctor.getSpecialite());
        doctorRepository.save(d);
        return d;
    }
}
