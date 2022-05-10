package com.momo.gestiondestock.controller.api;

import com.momo.gestiondestock.dto.ArticleDto;
import com.momo.gestiondestock.dto.RolesDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.momo.gestiondestock.utils.Constants.APP_ROOT;


@Api("Roles")
public interface RoleApi {

    @PostMapping(value = APP_ROOT + "/roles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    RolesDto save(RolesDto dto);

    @GetMapping(value = APP_ROOT + "/roles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    RolesDto findById(Integer id);

    @GetMapping(value = APP_ROOT + "/roles/{Lib}", produces = MediaType.APPLICATION_JSON_VALUE)
    RolesDto findByLibelle(@PathVariable("Lib") String libelle);

    @GetMapping(value = APP_ROOT + "/roles", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des roles", notes = "Cette methode permet renvoi la liste des articles", response = RolesDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message= "L'objet role a été bien trouver")
    })
    List<RolesDto> findAll();

    @PutMapping(value = APP_ROOT + "/roles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    RolesDto put(RolesDto dto, Integer id);

    @DeleteMapping(value = APP_ROOT + "/roles/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(Integer id);
}
