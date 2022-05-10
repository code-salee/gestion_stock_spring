package com.momo.gestiondestock.service.impl;

import com.momo.gestiondestock.dto.EntrepriseDto;
import com.momo.gestiondestock.dto.RolesDto;
import com.momo.gestiondestock.exception.EntityNotFoundException;
import com.momo.gestiondestock.exception.ErrorCodes;
import com.momo.gestiondestock.model.Entreprise;
import com.momo.gestiondestock.model.Roles;
import com.momo.gestiondestock.repository.EntrepriseRepository;
import com.momo.gestiondestock.repository.RoleRepository;
import com.momo.gestiondestock.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }
    @Override
    public RolesDto save(RolesDto dto) {
        return RolesDto.fromEntity(
                roleRepository.save(
                        RolesDto.toEntity(dto)
                )
        );
    }

    @Override
    public RolesDto findById(Integer id) {
        if(id == null){
            log.error("Role ID is null");
            return null;
        }
        Optional<Roles> roles = roleRepository.findById(id);
        RolesDto dto = RolesDto.fromEntity(roles.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException(
                        "Un role avec cet: " + id + " n'existe pas",
                        ErrorCodes.ROLE_NOT_FOUND
                )
        );
    }

    @Override
    public RolesDto findByLibelle(String libelle) {
        if (!StringUtils.hasLength(libelle)){
            log.error("Libelle role is not valid");
            return null;
        }
        Optional<Roles> roles = roleRepository.findByLibelle(libelle);
        RolesDto dto = RolesDto.fromEntity(roles.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException(
                        "Un role avec cet libelle: " + libelle + " n'existe pas",
                        ErrorCodes.ROLE_NOT_FOUND
                )
        );
    }

    @Override
    public List<RolesDto> findAll() {
        return roleRepository.findAll().stream()
                .map(RolesDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public RolesDto put(RolesDto dto, Integer id) {
        if(id == null){
            log.error("Role ID is null");
            return null;
        }
        return RolesDto.fromEntity(
                roleRepository.save(
                        RolesDto.toEntity(dto)
                )
        );
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Role ID is null");
            return;
        }
        roleRepository.deleteById(id);
    }
}
