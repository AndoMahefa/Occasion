package com.voiture.occasion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.occasion.model.Annonce;
import com.voiture.occasion.model.Categorie;
import com.voiture.occasion.model.Energie;
import com.voiture.occasion.model.Marque;
import com.voiture.occasion.model.Modele;
import com.voiture.occasion.repository.AnnonceRepository;

@Service
public class AnnonceService {
    @Autowired
    AnnonceRepository repository;
    // user
    public Annonce createAnnonce(String description, String dateAnnonce, String miseCirculation, String idUtilisateur, String idCategorie,
            String idMarque, String idModele, String idEnergie) {
        Annonce annonce = new Annonce();
        annonce.setDescription(description);
        annonce.setDateAnnonce(dateAnnonce);
        annonce.setMiseCirculation(miseCirculation);
        annonce.setStatus("0");
        annonce.setIdUtilisateur(idUtilisateur);
        annonce.setCategorie(new Categorie(idCategorie));
        annonce.setMarque(new Marque(idMarque));
        annonce.setModele(new Modele(idModele));
        annonce.setEnergie(new Energie(idEnergie));
        return repository.save(annonce);
    }

    
    public void updateStatus(String id, String status) throws Exception {
        Optional<Annonce> annonce = repository.findById(id);
        if (annonce.isPresent()) {
            Annonce newStatus = annonce.get();
            newStatus.setStatus(status);
            repository.save(newStatus);
        } else {
            throw new Exception("Annonce is not present");
        }
    }

    public List<Annonce> getByUtilisateur(String idUtilisateur) {
        return repository.findByUtilisateur(idUtilisateur);
    }

    public void addFavoris(String idAnnonce, String idUtilisateur) {
        repository.saveFavoris(idAnnonce, idUtilisateur);
    }

    public List<Annonce> getFavoris(String idUtilisateur) {
        return repository.findFavoris(idUtilisateur);
    }
    // admin
    public void insertValidation(int etat, String idAnnonce) {
        repository.saveValidation(etat, idAnnonce);
    }

    public List<Annonce> getAllDemande() {
        return repository.findAllDemande();
    }
    
    // pubilc
    public List<Annonce> getAllValidate() {
        return repository.findAllValdidate();
    }

    public List<Annonce> searchByElements(String idCategorie, String idMarque, String idModele, String idEnergie) {
        
        return repository.findByElements(idCategorie, idMarque, idModele, idEnergie);
    }

    public Optional<Annonce> findById(String id) {
        return repository.findById(id);
    }

}
