package com.momo.gestiondestock.repository;

import com.momo.gestiondestock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface VentesRepository extends JpaRepository<Ventes, Integer> {


    List<Ventes> findAll();

    Optional<Ventes> findById(Integer id);

    Optional<Ventes> findByDateVente(Instant dateVente);

    Optional<Ventes> findByCode(String code);
}
