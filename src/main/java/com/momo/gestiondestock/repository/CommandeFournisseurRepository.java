package com.momo.gestiondestock.repository;

import com.momo.gestiondestock.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Long> {

    List<CommandeFournisseur> findAll();

    Optional<CommandeFournisseur> findById(Long id);

    Optional<CommandeFournisseur> findByCodeAndIdNot(String code, Long id);

    Optional<CommandeFournisseur> findByDateCommande(Instant dateCommande);

    Optional<CommandeFournisseur> findByCode(String code);
}
