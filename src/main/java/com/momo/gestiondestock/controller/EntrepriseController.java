package com.momo.gestiondestock.controller;

import com.momo.gestiondestock.controller.api.EntrepriseApi;
import com.momo.gestiondestock.dto.EntrepriseDto;
import com.momo.gestiondestock.service.EntrepriseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
public class EntrepriseController implements EntrepriseApi {

    private EntrepriseService entrepriseService;

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        return entrepriseService.save(dto);
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        return entrepriseService.findById(id);
    }

    @Override
    public EntrepriseDto findByNom(String nom) {
        return entrepriseService.findByNom(nom);
    }

    @Override
    public EntrepriseDto findByNumTel(String numTel) {
        return entrepriseService.findByNumTel(numTel);
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseService.findAll();
    }

    @Override
    public EntrepriseDto put(EntrepriseDto dto, Integer id) {
        return entrepriseService.put(dto, id);
    }

    @Override
    public void delete(Integer id) {
        entrepriseService.delete(id);
    }
}
