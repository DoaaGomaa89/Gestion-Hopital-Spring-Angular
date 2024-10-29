package com.example.demo.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissane;

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

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", nom='" + nom +
                ", dateNaissane=" + dateNaissane +
                '}';
    }
}
