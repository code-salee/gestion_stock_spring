package com.momo.gestiondestock.service;

import com.momo.gestiondestock.dto.RolesDto;

import java.util.List;

public interface RoleService {

    RolesDto save(RolesDto dto);

    RolesDto findById(Integer id);

    RolesDto findByLibelle(String libelle);

    List<RolesDto> findAll();

    RolesDto put(RolesDto dto, Integer id);

    void delete(Integer id);
}
