package com.example.demo.DTO;


import java.util.Date;

public class DoctorRequest {
    private Long id;
    private String nom;
    private Date dateNaissane;
    private String specialite;
    private Long hospitalId;

    public DoctorRequest() {}

    public String getSpecialite() {
        return specialite;
    }

    public Date getDateNaissane() {
        return dateNaissane;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setDateNaissane(Date dateNaissane) {
        this.dateNaissane = dateNaissane;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
