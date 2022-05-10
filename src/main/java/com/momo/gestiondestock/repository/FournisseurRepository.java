package com.momo.gestiondestock.repository;

import com.momo.gestiondestock.model.Client;
import com.momo.gestiondestock.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {


    List<Fournisseur> findAll();

    Optional<Fournisseur> findById(Long id);

    Optional<Fournisseur> findByNumTel(String numtel);

    Optional<Fournisseur> findByEmail(String email);
}
