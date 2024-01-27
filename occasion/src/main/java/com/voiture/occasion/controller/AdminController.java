package com.voiture.occasion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.occasion.model.Annonce;
import com.voiture.occasion.model.Categorie;
import com.voiture.occasion.model.Energie;
import com.voiture.occasion.model.Marque;
import com.voiture.occasion.model.Modele;
import com.voiture.occasion.repository.CategorieRepository;
import com.voiture.occasion.repository.EnergieRepository;
import com.voiture.occasion.repository.MarqueRepository;
import com.voiture.occasion.repository.ModeleRepository;
import com.voiture.occasion.service.AnnonceService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class AdminController {
    @Autowired
    AnnonceService annonceRep;
    @Autowired 
    private ModeleRepository modeleRep;
    @Autowired
    private MarqueRepository marqueRep;
    @Autowired
    private CategorieRepository categorieRep;
    @Autowired
    private EnergieRepository energieRep;
    
    // categorie
    @PostMapping("/admin/categorie")
    public Categorie createCategorie(@RequestBody Categorie categorie) {
        return categorieRep.save(categorie);
    }

    @GetMapping("/admin/categories") 
    public @ResponseBody  List<Categorie> getAllCategorie() {
        return categorieRep.findAll();
    }

    @GetMapping("/admin/categorie/{idcategorie}")
    public @ResponseBody Optional<Categorie> getByIdCategorie(@PathVariable(name = "idcategorie") String idCategorie) {
        return categorieRep.findById(idCategorie);
    }

    @DeleteMapping("/admin/categorie/{idcategorie}")
    public void deleteCategorie(@PathVariable(name = "idcategorie") String idModele) {
        modeleRep.deleteById(idModele);
    }

    // marque
    @PostMapping("/admin/marque")
    public Marque createMarque(@RequestBody Marque marque) {
        return marqueRep.save(marque);
    }

    @GetMapping("/admin/marques") 
    public @ResponseBody  List<Marque> getAllMarque() {
        return marqueRep.findAll();
    }

    @GetMapping("/admin/marque/{idmarque}")
    public @ResponseBody Optional<Marque> getByIdMarque(@PathVariable(name = "idmarque") String idMarque) {
        return marqueRep.findById(idMarque);
    }

    @DeleteMapping("/admin/marque/{idmarque}")
    public void deleteMarque(@PathVariable(name = "idmarque") String idMarque) {
        modeleRep.deleteById(idMarque);
    }

    // modele
    @PostMapping("/admin/modele")
    public Modele createModele(@RequestParam(name = "nomModele") String nom, @RequestParam(name = "idmarque") String idmarque, @RequestParam(name = "idcategorie") String idcategorie ) {
        return modeleRep.saveModele(nom, idmarque, idcategorie);
    }

    @GetMapping("/admin/modeles")
    public @ResponseBody List<Modele> getAllModele(){
        return modeleRep.findAll();
    }

    @GetMapping("/admin/modele/{idmodele}")
    public @ResponseBody Optional<Modele> getByIdModele(@PathVariable(name = "idmodele") String idModele){
        return modeleRep.findById(idModele);
    }

    @DeleteMapping("/admin/modele/{idmodele}")
    public void deleteModele(@PathVariable(name = "idmodele") String idModele) {
        modeleRep.deleteById(idModele);
    }

    // energie    
    @PostMapping("/admin/energie")
    public Energie createEnergie(@RequestBody Energie energie) {
        return energieRep.save(energie);
    }

    @GetMapping("/admin/energies") 
    public @ResponseBody  List<Energie> getAllEnergie() {
        return energieRep.findAll();
    }

    @GetMapping("/admin/energie/{id}")
    public @ResponseBody Optional<Energie> getByIdEnergie(@PathVariable(name = "id") String id) {
        return energieRep.findById(id);
    }

    @DeleteMapping("/admin/energie/{idmodele}")
    public void deleteEnergie(@PathVariable(name = "idmodele") String idModele) {
        modeleRep.deleteById(idModele);
    }

    // annonce 
    @PostMapping("/admin/annonce/{idannonce}/{etat}")
    public ResponseEntity<String> insertValidation(@PathVariable(name = "idannonce") String id, @PathVariable(name = "etat") int etat) {
        try { annonceRep.insertValidation(etat, id); } 
        catch (Exception e) { return ResponseEntity.ok("Error validation"); }        
        return ResponseEntity.ok("Add favoris successfully");
    }

    @GetMapping("/admin/annonces")
    public List<Annonce> getAllDemande() {
        return annonceRep.getAllDemande();
    }
    
    
}
