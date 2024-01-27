package com.voiture.occasion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.occasion.model.Annonce;
import com.voiture.occasion.service.AnnonceService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class UserController {
    @Autowired
    AnnonceService service;

    @PostMapping("/user/annonce")
    public Annonce create(
        @RequestParam(name = "description") String description, 
        @RequestParam(name = "dateAnnonce") String dateAnnonce, 
        @RequestParam(name = "miseCirculation") String miseCirculation, 
        @RequestParam(name = "idUtilisateur") String idUtilisateur, 
        @RequestParam(name = "idCategorie") String idCategorie, 
        @RequestParam(name = "idMarque") String idMarque, 
        @RequestParam(name = "idModele") String idModele, 
        @RequestParam(name = "idEnergie") String idEnergie) {
        return service.createAnnonce(description, dateAnnonce, miseCirculation, idUtilisateur, idCategorie, idMarque, idModele, idEnergie);
    }

    @GetMapping("/user/annonces/{iduser}")
    public List<Annonce> getByUtilisateur(@PathVariable(name = "iduser") String idUtilisateur) {
        return service.getByUtilisateur(idUtilisateur);
    }

    @GetMapping("/user/historiques/{iduser}")
    public List<Annonce> getHistorique(@PathVariable(name = "id") String idUtilisateur) {
        return service.getByUtilisateur(idUtilisateur);
    }

    @PutMapping("/user/annonce/{id}")
    public ResponseEntity<String> updateStatus(@PathVariable("id") String id, @RequestParam(name = "status") String status) {
        try { service.updateStatus(id, status); } 
        catch (Exception e) { return ResponseEntity.ok("Error update"); }        
        return ResponseEntity.ok("Column update successfully");
    }

    @PostMapping("/user/favoris/{id}/{iduser}")
    public ResponseEntity<String> addFavoris(@PathVariable("id") String id, @PathVariable("iduser") String idUtilisateur)  {
        try { service.addFavoris(id, idUtilisateur); } 
        catch (Exception e) { return ResponseEntity.ok("Error add"); }        
        return ResponseEntity.ok("Add favoris successfully");
    }
    
    @GetMapping("/user/favoris/{iduser}")
    public List<Annonce> getFavoris(@PathVariable(name = "iduser") String idUtilisateur) {
        return service.getByUtilisateur(idUtilisateur);
    }

        
}
