package com.momo.gestiondestock.controller.api;

import com.momo.gestiondestock.dto.ArticleDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.momo.gestiondestock.utils.Constants.APP_ROOT;

@Api("Articles")
public interface ArticleApi {

    @PostMapping(value = "/articles/create")
    @ApiOperation(value = "Enregistrer un article", notes = "Cette methode permet d'enregistrer ou modifier un article", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet article creer/modifier")
    })
    ArticleDto save(ArticleDto dto);

    //si le meme variable est passé en parametre sur la methode (comme findById) et sur le path donc on a pas besoin d'utiliser le @pathVariable
    @GetMapping(value = "/articles/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get un article", notes = "Cette methode de rechercher un article par ID", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet article a été bien trouver avec succes"),
            @ApiResponse(code = 404, message = "Aucun article trouvé avec cette ID")
    })
    ArticleDto findById(@PathVariable("id") Integer id);

    @GetMapping(value = APP_ROOT + "/articles/codearticle/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get un article", notes = "Cette methode de rechercher un article par code article", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message= "L'objet article a été bien trouver"),
            @ApiResponse(code = 404, message= "Aucun article trouvé avec cet code article")
    })
    ArticleDto findByCodearticle(@PathVariable("codeArticle") String codearticle);

    @GetMapping(value = "/articles/designation/{designation}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get un article", notes = "Cette methode de rechercher un article par designation", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message= "L'objet article a été bien trouver"),
            @ApiResponse(code = 404, message= "Aucun article trouvé avec cete designation")
    })
    ArticleDto findByDesignation(@PathVariable("designation") String designation);

    @GetMapping(value = "/articles", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des articles", notes = "Cette methode permet renvoi la liste des articles", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message= "L'objet article a été bien trouver avec succes")
    })
    List<ArticleDto> findAll();

    @PutMapping(value = "/articles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modifier un article", notes = "Cette methode permet de modifier un article par id", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message= "L'objet article a été bien modifier"),
            @ApiResponse(code = 404, message= "Aucun article trouvé avec cete ID")
    })
    ArticleDto put(@RequestBody  ArticleDto dto, @PathVariable Integer id);
    @DeleteMapping(value = "/articles/delete/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Supprimer un article", notes = "Cette methode permet de supprimer un article", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message= "L'objet article a été bien supprimer"),
            @ApiResponse(code = 404, message= "Aucun article trouvé avec cete ID")
    })
    void delete(@PathVariable("idArticle") Integer id);

}
