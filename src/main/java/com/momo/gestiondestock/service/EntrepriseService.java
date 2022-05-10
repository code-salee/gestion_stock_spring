package com.momo.gestiondestock.service;

import com.momo.gestiondestock.dto.EntrepriseDto;
import com.momo.gestiondestock.model.Entreprise;

import java.util.List;

public interface EntrepriseService {

    EntrepriseDto save(EntrepriseDto dto);

    EntrepriseDto findById(Integer id);

    EntrepriseDto findByNom(String nom);

    EntrepriseDto findByNumTel(String numTel);

    List<EntrepriseDto> findAll();

    EntrepriseDto put(EntrepriseDto dto, Integer id);

    void delete(Integer id);
}
