package com.example.demo.Entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissane;
    private boolean malade;
    private int score;

    public Patient() {}
    public Patient(String nom, Date dateNaissane, boolean malade, int score) {
        this.nom = nom;
        this.dateNaissane = dateNaissane;
        this.malade = malade;
        this.score = score;
    }
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}
    public Date getDateNaissane() {return dateNaissane;}
    public void setDateNaissane(Date dateNaissane) {
        this.dateNaissane = dateNaissane;
    }
    public boolean isMalade() {return malade;}
    public void setMalade(boolean malade) {this.malade = malade;}
    public int getScore() {return score;}
    public void setScore(int score) {this.score = score;}

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", nom='" + nom +
                ", dateNaissane=" + dateNaissane +
                ", malade=" + malade +
                ", score=" + score +
                '}';
    }
}
