package com.momo.gestiondestock.datafixtures;


import com.momo.gestiondestock.model.Adresse;
import com.momo.gestiondestock.model.Utilisateur;
import com.momo.gestiondestock.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@AllArgsConstructor
@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
@Order(2)
public class UserFixtures implements CommandLineRunner {

    private UtilisateurRepository utilisateurRepository;
    private  EntrepriseRepository entrepriseRepository;
    private  RoleRepository roleRepository;
    @Override
    public void run(String... args) throws Exception {
        Adresse adresse = new Adresse("scat urbam", "", "Dakar", "24000", "Senegal");
        String password = "password";
        Date date = new Date();
        utilisateurRepository.saveAll(Arrays.asList(
                new Utilisateur("Fatou", "Diop", "fatou@diop.com", date, password, adresse, "", entrepriseRepository.findAll().get(0), roleRepository.findAll().get(0)),
                new Utilisateur("Modou", "Ndiaye", "modou@ndiaye.com", date, password, adresse, "", entrepriseRepository.findAll().get(1), roleRepository.findAll().get(1)),
                new Utilisateur("Laye", "Babou", "laye@babou.com", date, password, adresse, "", entrepriseRepository.findAll().get(2), roleRepository.findAll().get(0))
        ));
    }
}


