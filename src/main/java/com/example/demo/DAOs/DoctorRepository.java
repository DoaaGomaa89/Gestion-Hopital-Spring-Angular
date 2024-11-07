package com.example.demo.DAOs;

import com.example.demo.Entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    public List<Doctor> findDoctorsByHospitalId(Long hospitalid);
}
