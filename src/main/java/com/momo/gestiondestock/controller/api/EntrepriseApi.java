package com.momo.gestiondestock.controller.api;

import com.momo.gestiondestock.dto.EntrepriseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

import static com.momo.gestiondestock.utils.Constants.APP_ROOT;

public interface EntrepriseApi {

    @PostMapping(value = APP_ROOT + "/entreprises/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto save(EntrepriseDto dto);

    @GetMapping(value = APP_ROOT + "/entreprises/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findById(Integer id);

    @GetMapping(value = APP_ROOT + "/entreprises/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findByNom(String nom);

    @GetMapping(value = APP_ROOT + "/entreprises/{numTel}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findByNumTel(String numTel);

    @GetMapping(value = APP_ROOT + "/entreprises", produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntrepriseDto> findAll();

    @PutMapping(value = APP_ROOT + "/entreprises/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto put(EntrepriseDto dto, Integer id);

    @DeleteMapping(value = APP_ROOT + "/entreprises/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(Integer id);

}
