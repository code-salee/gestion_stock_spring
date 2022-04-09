package com.momo.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.momo.gestiondestock.model.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class CategoryDto {

    private Integer id;


    private String code;


    private String designation;


    @JsonIgnore
    private List<ArticleDto> articles;

    //Mapping entité dto: fromEntity permet de mapper une relation de l'entité (Category) vers dto (CategoryDto)
    public static CategoryDto fromEntity (Category category) {
        if(category == null){
            return null;
        }

        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .build();
    }

    //Mapping entité dto: toEntity permet ude mapper ne relation de dto vers l'entité
    public static Category toEntity (CategoryDto categoryDto){
        if(categoryDto== null){
            return null;
        }
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesignation(categoryDto.getDesignation());
        return category;
    }
}
