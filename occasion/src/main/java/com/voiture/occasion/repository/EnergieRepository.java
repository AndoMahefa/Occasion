package com.voiture.occasion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voiture.occasion.model.Energie;

@Repository
public interface EnergieRepository extends JpaRepository<Energie, String> {
    
}
