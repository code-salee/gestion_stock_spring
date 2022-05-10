package com.momo.gestiondestock.controller;

import com.momo.gestiondestock.controller.api.CategoryApi;
import com.momo.gestiondestock.dto.CategoryDto;
import com.momo.gestiondestock.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryController implements CategoryApi {


    private CategoryService categoryService;


    @Override
    public CategoryDto save(CategoryDto dto) {
        return categoryService.save(dto);
    }

    @Override
    public CategoryDto findById(Integer id) {
        return categoryService.findById(id);
    }

    @Override
    public CategoryDto findByCode(String code) {return categoryService.findByCode(code);}

    @Override
    public List<CategoryDto> findAll() {return categoryService.findAll();}

    @Override
    public CategoryDto put(CategoryDto dto, Integer id) {
        return categoryService.put(dto, id);
    }
    @Override
    public void delete(Integer id) {
        categoryService.delete(id);}
}
