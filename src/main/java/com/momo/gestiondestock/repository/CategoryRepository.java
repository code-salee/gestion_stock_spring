package com.momo.gestiondestock.repository;


import com.momo.gestiondestock.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findAll();

    Optional<Category> findById(Integer id);

    Optional<Category> findByCodeAndIdNot(String code, Long id);

    Optional<Category> findByDesignationAndIdNot(String designation, Long id);

    Optional<Category> findByCode(String code);
}
