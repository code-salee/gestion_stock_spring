package com.momo.gestiondestock.repository;

import com.momo.gestiondestock.model.LigneCommandeFournisseur;
import com.momo.gestiondestock.model.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LigneVenteRepository extends JpaRepository<LigneVente, Long> {

    List<LigneVente> findAll();

    Optional<LigneVente> findById(Long id);
}
