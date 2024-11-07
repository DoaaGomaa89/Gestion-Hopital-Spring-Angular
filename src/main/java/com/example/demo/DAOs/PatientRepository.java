package com.example.demo.DAOs;

import com.example.demo.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    public List<Patient> getAllThePatientsByDoctorId(Long doctorId);
}
