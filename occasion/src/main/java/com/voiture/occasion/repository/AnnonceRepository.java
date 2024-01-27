package com.voiture.occasion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.voiture.occasion.model.Annonce;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, String> {
    // user 
    @Query(value = "select * from annonce_validation where id_utilisateur = :idutilisateur", nativeQuery = true)
    public List<Annonce> findByUtilisateur(@Param("idutilisateur") String idUtilisateur);

    @Query(value = "insert into favoris (id_annonce, id_utilisateur) values (:idannonce, :idutilisateur)", nativeQuery = true)
    public void saveFavoris(@Param("idannonce") String idAnnonce, @Param("idutilisateur") String idUtilisateur);

    @Query(value = "select * from annonce_favoris where id_utilisateur = :idutilisateur", nativeQuery = true)
    public List<Annonce> findFavoris(@Param("idutilisateur") String idUtilisateur);


    // admin
    @Query(value = "insert into validation (etat, date, id_annonce) values (:etat, now(), :idannonce)", nativeQuery = true)
    public void saveValidation(
        @Param("etat") int etat,
        @Param("idannonce") String idAnnonce
    ); 

    @Query(value = "select * from annonce_validation where etat is null", nativeQuery = true)
    public List<Annonce> findAllDemande();
    
    // public
    @Query(value = "select * from annonce_validation where etat = 1", nativeQuery = true)
    public List<Annonce> findAllValdidate();
    
    @Query(value = "select * from annonce_validation where etat = 1 and  id_categorie = :idcategorie  and id_marque = :idmarque  and id_modele =  :idmodele and id_energie =  :idenergie)", nativeQuery = true)
    public List<Annonce> findByElements(
        @Param("idcategorie") String idCategorie,
        @Param("idmarque") String idMarque,
        @Param("idmodele") String idModele,
        @Param("idenergie") String idEnergie
    );

}



