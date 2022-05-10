package com.momo.gestiondestock.service.impl;

import com.momo.gestiondestock.dto.CategoryDto;
import com.momo.gestiondestock.dto.UtilisateurDto;
import com.momo.gestiondestock.exception.EntityNotFoundException;
import com.momo.gestiondestock.exception.ErrorCodes;
import com.momo.gestiondestock.exception.InvalidEntityException;
import com.momo.gestiondestock.model.Category;
import com.momo.gestiondestock.model.Utilisateur;
import com.momo.gestiondestock.repository.RoleRepository;
import com.momo.gestiondestock.repository.UtilisateurRepository;
import com.momo.gestiondestock.service.UtilisateurService;
import com.momo.gestiondestock.validator.CategoryValidator;
import com.momo.gestiondestock.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        List<String> errors = UtilisateurValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Utilisateur is not valid {}", dto);
            throw new InvalidEntityException("Category n'est valide", ErrorCodes.CATEGORY_NOT_FOUND, errors);
        }
        return UtilisateurDto.fromEntity(
                utilisateurRepository.save(
                            UtilisateurDto.toEntity(dto)
                )
        );
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if(id == null){
            log.error("Utilisateur ID is null");
            return null;
        }
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        UtilisateurDto dto = UtilisateurDto.fromEntity(utilisateur.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException(
                        "Un utilisateur avec cet: " + id + " n'existe pas",
                        ErrorCodes.UTILISATEUR_NOT_FOUND
                )
        );
    }

    @Override
    public UtilisateurDto findByEmail(String email) {
        if (!StringUtils.hasLength(email)){
            log.error("Email utilisateur is not valid");
            return null;
        }
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmail(email);
        UtilisateurDto dto = UtilisateurDto.fromEntity(utilisateur.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException(
                        "Un utilisateur avec cet email: " + email + " n'existe pas",
                        ErrorCodes.UTILISATEUR_NOT_FOUND
                )
        );
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UtilisateurDto put(UtilisateurDto dto, Integer id) {
        List<String> Errors = UtilisateurValidator.validate(dto);
        if(!Errors.isEmpty()){
            log.error("Utilisateur is not valid {}", dto);
            throw new InvalidEntityException("Le category n'est valide", ErrorCodes.UTILISATEUR_NOT_VALID, Errors);
        }
        return UtilisateurDto.fromEntity(
                utilisateurRepository.save(
                        UtilisateurDto.toEntity(dto)
                )
        );
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Utilisateur ID is null");
            return;
        }
        utilisateurRepository.deleteById(id);
    }
}
