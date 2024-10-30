package com.example.demo.DTO;
import java.util.*;

public class PatientRequest {
    private String nom;
    private Date dateNaissane;
    private boolean malade;
    private int score;
    private Long doctorId;  // This is used to link the doctor

    public PatientRequest() {}
    public String getNom() {return nom;}
    public Date getDateNaissane() {return dateNaissane;}

    public boolean isMalade() {
        return malade;
    }

    public int getScore() {
        return score;
    }
    public Long getDoctorId() {return doctorId;}
    public void setNom(String nom) {this.nom = nom;}
    public void setDateNaissane(Date dateNaissane) {this.dateNaissane = dateNaissane;}
    public void setMalade(boolean malade) {this.malade = malade;}
    public void setScore(int score) {this.score = score;}
    public void setDoctorId(Long doctorId) {this.doctorId = doctorId;}

}
