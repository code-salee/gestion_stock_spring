package com.momo.gestiondestock.service.impl;

import com.momo.gestiondestock.dto.CategoryDto;
import com.momo.gestiondestock.exception.EntityNotFoundException;
import com.momo.gestiondestock.exception.ErrorCodes;
import com.momo.gestiondestock.exception.InvalidEntityException;
import com.momo.gestiondestock.model.Category;
import com.momo.gestiondestock.repository.CategoryRepository;
import com.momo.gestiondestock.service.CategoryService;
import com.momo.gestiondestock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        Random random = new Random();
        String code = "ART" + (random.nextInt((9999 - 1000) + 1) + 1);
        dto.setCode(code);
        List<String> errors = CategoryValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Category is not valid {}", dto);
            throw new InvalidEntityException("Category n'est valide", ErrorCodes.CATEGORY_NOT_FOUND, errors);
        }
        return CategoryDto.fromEntity(
                categoryRepository.save(
                        CategoryDto.toEntity(dto)
                )
        );
    }

    @Override
    public CategoryDto findById(Integer id) {
        if(id == null){
            log.error("Category ID is null");
            return null;
        }
        Optional<Category> category = categoryRepository.findById(id);
        CategoryDto dto = CategoryDto.fromEntity(category.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException(
                        "Un category avec cet: " + id + " n'existe pas",
                        ErrorCodes.CATEGORY_NOT_FOUND
                )
        );
    }

    @Override
    public CategoryDto findByCode(String code) {
        if (!StringUtils.hasLength(code)){
            log.error("Code category is not valid");
            return null;
        }
        Optional<Category> category = categoryRepository.findByCode(code);
        CategoryDto dto = CategoryDto.fromEntity(category.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException(
                        "Un category avec cet code: " + code + " n'existe pas",
                        ErrorCodes.CATEGORY_NOT_FOUND
                )
        );
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto put(CategoryDto dto, Integer id) {
        List<String> Errors = CategoryValidator.validate(dto);
        if(!Errors.isEmpty()){
            log.error("Category is not valid {}", dto);
            throw new InvalidEntityException("Le category n'est valide", ErrorCodes.CATEGORY_NOT_VALID, Errors);
        }
        return CategoryDto.fromEntity(
                categoryRepository.save(
                        CategoryDto.toEntity(dto)
                )
        );
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Category ID is null");
            return;
        }
        categoryRepository.deleteById(id);
    }
}
