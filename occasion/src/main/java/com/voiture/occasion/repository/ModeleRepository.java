package com.voiture.occasion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.voiture.occasion.model.Modele;

@Repository
public interface ModeleRepository extends JpaRepository<Modele, String> {
    @Query(value = "insert into modele (nom_modele, id_marque, id_categorie) values (:nom, :idmarque, :idcategorie)", nativeQuery = true)
    public Modele saveModele(
        @Param("nom") String nom,
        @Param("idmarque") String idMatiere,
        @Param("idcategorie") String idCategorie
    );
}
