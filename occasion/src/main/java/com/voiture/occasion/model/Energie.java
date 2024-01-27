package com.voiture.occasion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Energie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String idEnergie;
    String nomEnergie;
    
    public Energie() {
    }
    
    public Energie(String idEnergie) {
        this.idEnergie = idEnergie;
    }

    public String getIdEnergie() { return idEnergie; }

    public void setIdEnergie(String idEnergie) { this.idEnergie = idEnergie; }

    public String getNomEnergie() { return nomEnergie; }

    public void setNomEnergie(String nomEnergie) { this.nomEnergie = nomEnergie; }
}
