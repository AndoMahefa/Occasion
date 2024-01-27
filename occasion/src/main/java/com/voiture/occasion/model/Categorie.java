package com.voiture.occasion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idCategorie;
    private String nomCategorie;

    public Categorie() {
    }

    public Categorie(String idCategorie) {
        this.setIdCategorie(idCategorie);
    }


    public String getIdCategorie() { return idCategorie; }

    public void setIdCategorie(String idCategorie) { this.idCategorie = idCategorie; }

    public String getNomCategorie() { return nomCategorie; }

    public void setNomCategorie(String nomCategorie) { this.nomCategorie = nomCategorie; }
}
