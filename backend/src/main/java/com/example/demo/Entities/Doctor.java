package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.*;

import com.example.demo.Entities.Patient;


@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissane;
    private String specialite;
    @OneToMany(mappedBy = "doctor")
    @JsonManagedReference
    private List<Patient> patients;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    @JsonBackReference
    private Hospital hospital;

    public Doctor() {}
    public Doctor(String nom, Date dateNaissane) {
        this.nom = nom;
        this.dateNaissane = dateNaissane;
    }
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}
    public Date getDateNaissane() {return dateNaissane;}
    public void setDateNaissane(Date dateNaissane) {
        this.dateNaissane = dateNaissane;
    }
    public String getSpecialite() {return specialite;}
    public void setSpecialite(String specialite) {this.specialite = specialite;}
    public List<Patient> getPatients() {return patients;}
    public void setPatients(List<Patient> patients) {this.patients = patients;}
    public Hospital getHospital() {return hospital;}
    public void setHospital(Hospital hospital) {this.hospital = hospital;}

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", nom='" + nom +
                ", dateNaissane=" + dateNaissane +
                '}';
    }
}
