package com.momo.gestiondestock.service;

import com.momo.gestiondestock.dto.ArticleDto;
import com.momo.gestiondestock.dto.CategoryDto;
import com.momo.gestiondestock.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    CategoryDto save(CategoryDto dto);

    CategoryDto findById(Integer id);

    CategoryDto findByCode(String code);

    List<CategoryDto> findAll();

    CategoryDto put(CategoryDto dto, Integer id);

    void delete(Integer id);
}
