package com.voiture.occasion.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.voiture.occasion.helper.Utils;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String idAnnonce;
    String description;
    LocalDateTime dateAnnonce;
    LocalDate miseCirculation;
    int status;
    @Transient
    int etat;
    @Transient
    LocalDateTime dateValidation;
    String idUtilisateur;
    @ManyToOne @JoinColumn(name = "id_categorie") 
    Categorie categorie;
    @ManyToOne @JoinColumn(name = "id_marque") 
    Marque marque;
    @ManyToOne @JoinColumn(name = "id_modele") 
    Modele modele;
    @ManyToOne @JoinColumn(name = "id_energie") 
    Energie energie;

    
    public Annonce() {
    }

    public String getIdAnnonce() { return idAnnonce; }

    public void setIdAnnonce(String idAnnonce) { this.idAnnonce = idAnnonce; }

    public LocalDateTime getDateAnnonce() { return dateAnnonce; }

    public void setDateAnnonce(String dateAnnonce) { this.dateAnnonce = Utils.stringToDateTime(dateAnnonce); }

    public LocalDate getMiseCirculation() { return miseCirculation; }

    public void setMiseCirculation(String miseCirculation) { this.miseCirculation = LocalDate.parse(miseCirculation); }

    public Categorie getCategorie() { return categorie; }

    public void setCategorie(Categorie categorie) { this.categorie = categorie; }

    public Marque getMarque() { return marque; }

    public void setMarque(Marque marque) { this.marque = marque; }

    public Modele getModele() { return modele; }

    public void setModele(Modele modele) { this.modele = modele; }

    public Energie getEnergie() { return energie; }

    public void setEnergie(Energie energie) { this.energie = energie; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getStatus() { return status; }

    public void setStatus(String status) { this.status = Integer.parseInt(status); }

    public void setDateAnnonce(LocalDateTime dateAnnonce) { this.dateAnnonce = dateAnnonce; }

    public int getEtat() { return etat; }

    public void setEtat(String etat) { this.etat = Integer.parseInt(etat); }

    public LocalDateTime getDateValidation() { return dateValidation; }

    public void setDateValidation(String dateValidation) { this.dateValidation = Utils.stringToDateTime(dateValidation); }

    public String getIdUtilisateur() { return idUtilisateur;  }

    public void setIdUtilisateur(String idUtilisateur) { this.idUtilisateur = idUtilisateur; }

    
}
