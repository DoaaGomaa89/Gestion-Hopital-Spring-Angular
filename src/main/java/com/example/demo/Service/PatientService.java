package com.example.demo.Service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demo.Entities.Patient;
import com.example.demo.DAOs.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> showall() {
        return patientRepository.findAll();
    }

    public Patient getPatientbyId(Long id) {
        return patientRepository.findById(id).get();

    }

    public void deletePatientById(Long id) {
         patientRepository.deleteById(id);
        System.out.println("Deleted Patient by Success");
    }

    public Patient updatePatientById(Long id,Patient patient) {
        Patient p = patientRepository.findById(id).get();
        p.setNom(patient.getNom());
        p.setDateNaissane(patient.getDateNaissane());
        p.setMalade(patient.isMalade());
        p.setScore(patient.getScore());
        return patientRepository.save(p);
    }
}
