package com.momo.gestiondestock.service;

import com.momo.gestiondestock.dto.ArticleDto;
import com.momo.gestiondestock.dto.ClientDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto dto);

    ArticleDto findById(Integer id);

    ArticleDto findByCodearticle(String codearticle);

    ArticleDto findByDesignation(String designation);

    List<ArticleDto> findAll();

    ArticleDto put(ArticleDto dto, Integer id);

    void delete(Integer id);
}
