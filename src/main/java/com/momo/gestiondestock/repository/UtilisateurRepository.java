package com.momo.gestiondestock.repository;

import com.momo.gestiondestock.model.Client;
import com.momo.gestiondestock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository <Utilisateur, Integer> {

    List<Utilisateur> findAll();

    Optional<Utilisateur> findById(Integer id);

    Optional<Utilisateur> findByEmail(String email);
}
