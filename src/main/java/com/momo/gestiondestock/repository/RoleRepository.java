package com.momo.gestiondestock.repository;

import com.momo.gestiondestock.model.Category;
import com.momo.gestiondestock.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository <Roles, Integer> {

    List<Roles> findAll();

    Optional<Roles> findById(Integer id);

    Optional<Roles> findByLibelle(String libelle);

}
