package com.momo.gestiondestock.controller.api;

import com.momo.gestiondestock.dto.UtilisateurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.momo.gestiondestock.utils.Constants.APP_ROOT;

public interface UtilisateurApi {

    @PostMapping(value = APP_ROOT + "/utilisateurs/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto save(UtilisateurDto dto);

    @GetMapping(value = APP_ROOT + "/utilisateurs/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findById(Integer id);

    @GetMapping(value = APP_ROOT + "/utilisateurs/{Mail}", produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findByEmail(@PathVariable("Mail") String email);

    @GetMapping(value = APP_ROOT + "/utilisateurs", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UtilisateurDto> findAll();

    @PutMapping(value = APP_ROOT + "/utilisateurs/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto put(UtilisateurDto dto, Integer id);

    @DeleteMapping(value = APP_ROOT + "/utilisateurs/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(Integer id);
}
