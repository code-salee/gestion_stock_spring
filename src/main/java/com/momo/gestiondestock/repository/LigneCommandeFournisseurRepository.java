package com.momo.gestiondestock.repository;

import com.momo.gestiondestock.model.LigneCommandeClient;
import com.momo.gestiondestock.model.LigneCommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LigneCommandeFournisseurRepository extends JpaRepository<LigneCommandeFournisseur, Long> {

    List<LigneCommandeFournisseur> findAll();

    Optional<LigneCommandeFournisseur> findById(Long id);
}
