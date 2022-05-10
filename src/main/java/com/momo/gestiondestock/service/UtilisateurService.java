package com.momo.gestiondestock.service;


import com.momo.gestiondestock.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    UtilisateurDto save(UtilisateurDto dto);

    UtilisateurDto findById(Integer id);

    UtilisateurDto findByEmail(String email);

    List<UtilisateurDto> findAll();

    UtilisateurDto put(UtilisateurDto dto, Integer id);

    void delete(Integer id);

}
