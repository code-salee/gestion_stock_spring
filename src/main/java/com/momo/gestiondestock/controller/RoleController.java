package com.momo.gestiondestock.controller;

import com.momo.gestiondestock.controller.api.RoleApi;
import com.momo.gestiondestock.dto.RolesDto;
import com.momo.gestiondestock.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class RoleController implements RoleApi {

    private RoleService roleService;

    @Override
    public RolesDto save(RolesDto dto) {
        return roleService.save(dto);
    }

    @Override
    public RolesDto findById(Integer id) {
        return roleService.findById(id);
    }

    @Override
    public RolesDto findByLibelle(String libelle) {
        return roleService.findByLibelle(libelle);
    }

    @Override
    public List<RolesDto> findAll() {
        return roleService.findAll();
    }

    @Override
    public RolesDto put(RolesDto dto, Integer id) {
        return roleService.put(dto, id);
    }

    @Override
    public void delete(Integer id) {
        roleService.delete(id);
    }
}
