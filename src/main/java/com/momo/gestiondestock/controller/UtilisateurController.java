package com.momo.gestiondestock.controller;

import com.momo.gestiondestock.controller.api.UtilisateurApi;
import com.momo.gestiondestock.dto.UtilisateurDto;
import com.momo.gestiondestock.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
public class UtilisateurController implements UtilisateurApi {

    private UtilisateurService utilisateurService;

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        return utilisateurService.save(dto);
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        return utilisateurService.findById(id);
    }

    @Override
    public UtilisateurDto findByEmail(String email) {
        return utilisateurService.findByEmail(email);
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurService.findAll();
    }

    @Override
    public UtilisateurDto put(UtilisateurDto dto, Integer id) {
        return utilisateurService.put(dto, id);
    }

    @Override
    public void delete(Integer id) {
        utilisateurService.delete(id);
    }
}
