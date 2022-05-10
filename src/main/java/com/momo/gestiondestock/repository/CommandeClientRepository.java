package com.momo.gestiondestock.repository;

import com.momo.gestiondestock.model.CommandeClient;
import com.momo.gestiondestock.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer> {

    List<CommandeClient> findAll();

    Optional<CommandeClient> findById(Integer id);

    Optional<CommandeClient> findByCodeAndIdNot(String code, Integer id);

    Optional<CommandeClient> findByDateCommande(Instant dateCommande);

    Optional<CommandeClient> findByCode(String code);
}
