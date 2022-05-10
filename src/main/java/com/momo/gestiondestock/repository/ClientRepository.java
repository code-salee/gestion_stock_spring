package com.momo.gestiondestock.repository;

import com.momo.gestiondestock.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository <Client, Integer> {

    List<Client> findAll();

    Optional<Client> findById(Integer id);

    Optional<Client> findByNumTel(String numtel);

    Optional<Client> findByEmail(String email);
}
