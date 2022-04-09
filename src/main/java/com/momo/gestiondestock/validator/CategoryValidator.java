package com.momo.gestiondestock.validator;

import com.momo.gestiondestock.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static List<String> validate(CategoryDto categoryDto) {
        List<String> errors = new ArrayList();
        if(categoryDto == null || !StringUtils.hasLength(categoryDto.getCode())){
            errors.add("Veuillez renseigner le code de la catégorie");
        }
        if(categoryDto == null || !StringUtils.hasLength(categoryDto.getDesignation())){
            errors.add("Veuillez renseigner la designation de la catégorie");
        }
        if(categoryDto == null || !StringUtils.hasLength(categoryDto.getCode())){
            errors.add("Veuillez renseigner le code de la catégorie");
        }
        return errors;
    }
}
