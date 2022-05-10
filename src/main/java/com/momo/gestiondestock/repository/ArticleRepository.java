package com.momo.gestiondestock.repository;

import com.momo.gestiondestock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
/*import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;*/

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    List<Article> findAll();

    Optional<Article> findById(Integer id);

    Optional<Article> findByCodearticleAndIdNot(String codearticle, Integer id);

    Optional<Article> findByDesignationAndIdNot(String designation,  Integer id);

    Optional<Article> findByCodearticle(String codearticle);

    Optional<Article> findByDesignation(String designation);

  /*  @Query("select  a from article where codearticle = :code and description = :description")
    List<Article> findByCustomQuery (@Param('code') String c, @Param('designation') String d);

    @Query(value = "select * from article where code = :code", nativeQuery = true)
    List<Article> findByCustomNativeQuery(@Param('code') String c);*/



}
