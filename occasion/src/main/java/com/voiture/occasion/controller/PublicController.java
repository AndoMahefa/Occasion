package com.voiture.occasion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.occasion.model.Annonce;
import com.voiture.occasion.model.Utilisateur;
import com.voiture.occasion.service.AnnonceService;
import com.voiture.occasion.service.UtilisateurService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PublicController {
    @Autowired
    AnnonceService service;
    @Autowired
    private UtilisateurService userRep;

    @GetMapping("/public/annonces")
    public List<Annonce> getALlValidates() {
        return service.getAllValidate();
    }

    @GetMapping("/public/recherche")
    public List<Annonce> getRecherche(
        @RequestParam(name = "idCategorie") String idCategorie,
        @RequestParam(name = "idMarque") String idMarque,
        @RequestParam(name = "idModele") String idModele,
        @RequestParam(name = "idEnergie") String idEnergie
    ) {
        return service.searchByElements(idCategorie, idMarque, idModele, idEnergie);
    }
    

    @PostMapping("/public/signup")
    public Utilisateur signUp(@RequestBody Utilisateur utilisateur) {
        return userRep.save(utilisateur);
    }

    @PostMapping("/public/signin")
    public ResponseEntity<String> signIn(@RequestParam("email") String email, @RequestParam("password") String password) {
        try {
            String token = userRep.login(email, password);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    
}
