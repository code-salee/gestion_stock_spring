package com.momo.gestiondestock.repository;

import com.momo.gestiondestock.model.Client;
import com.momo.gestiondestock.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

    List<Entreprise> findAll();

    Optional<Entreprise> findById(Integer id);

    Optional<Entreprise> findByNumTel(String numtel);

    Optional<Entreprise> findByNom(String nom);
}
