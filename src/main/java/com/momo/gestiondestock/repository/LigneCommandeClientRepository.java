package com.momo.gestiondestock.repository;

import com.momo.gestiondestock.model.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient, Long> {

    List<LigneCommandeClient> findAll();

    Optional<LigneCommandeClient> findById(Long id);

}
