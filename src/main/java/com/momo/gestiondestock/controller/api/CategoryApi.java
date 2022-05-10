package com.momo.gestiondestock.controller.api;

import com.momo.gestiondestock.dto.ArticleDto;
import com.momo.gestiondestock.dto.CategoryDto;
import com.momo.gestiondestock.dto.ClientDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.momo.gestiondestock.utils.Constants.APP_ROOT;

@Api("Category")
public interface CategoryApi {

    @PostMapping(value = "/category/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un category", notes = "Cette methode permet d'enregistrer ou modifier un category", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet category creer/modifier")
    })
    CategoryDto save(CategoryDto dto);

    @GetMapping(value = APP_ROOT + "/category/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(Integer id);

    @GetMapping(value = APP_ROOT + "/category/{codeCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByCode(@PathVariable("codeCategory") String code);

    @GetMapping(value = APP_ROOT + "/category", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();

    @PutMapping(value = APP_ROOT + "/category/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto put(CategoryDto dto, Integer id);

    @DeleteMapping(value = APP_ROOT + "/category/delete/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idCategory")  Integer id);
}
