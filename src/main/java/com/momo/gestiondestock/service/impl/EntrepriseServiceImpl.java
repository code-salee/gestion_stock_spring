package com.momo.gestiondestock.service.impl;

import com.momo.gestiondestock.dto.EntrepriseDto;
import com.momo.gestiondestock.exception.EntityNotFoundException;
import com.momo.gestiondestock.exception.ErrorCodes;
import com.momo.gestiondestock.model.Entreprise;
import com.momo.gestiondestock.repository.EntrepriseRepository;
import com.momo.gestiondestock.service.EntrepriseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

    private EntrepriseRepository entrepriseRepository;

    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository){
        this.entrepriseRepository = entrepriseRepository;
    }


    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        return EntrepriseDto.fromEntity(
                entrepriseRepository.save(
                        EntrepriseDto.toEntity(dto)
                )
        );
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if(id == null){
            log.error("Entreprise ID is null");
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);
        EntrepriseDto dto = EntrepriseDto.fromEntity(entreprise.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException(
                        "Un entreprise avec cet: " + id + " n'existe pas",
                        ErrorCodes.ENTREPRISE_NOT_FOUND
                )
        );
    }

    @Override
    public EntrepriseDto findByNom(String nom) {
        if (!StringUtils.hasLength(nom)){
            log.error("Nom entreprise is not valid");
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findByNom(nom);
        EntrepriseDto dto = EntrepriseDto.fromEntity(entreprise.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException(
                        "Un entreprise avec cet code: " + nom + " n'existe pas",
                        ErrorCodes.ENTREPRISE_NOT_FOUND
                )
        );
    }

    @Override
    public EntrepriseDto findByNumTel(String numTel) {
        if (!StringUtils.hasLength(numTel)){
            log.error("numTel entreprise is not valid");
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findByNom(numTel);
        EntrepriseDto dto = EntrepriseDto.fromEntity(entreprise.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException(
                        "Un entreprise avec cet code: " + numTel + " n'existe pas",
                        ErrorCodes.ENTREPRISE_NOT_FOUND
                )
        );
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public EntrepriseDto put(EntrepriseDto dto, Integer id) {
        if(id == null){
            log.error("Entreprise ID is null");
            return null;
        }
        return EntrepriseDto.fromEntity(
                entrepriseRepository.save(
                        EntrepriseDto.toEntity(dto)
                )
        );
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Entreprise ID is null");
            return;
        }
        entrepriseRepository.deleteById(id);
    }
}
