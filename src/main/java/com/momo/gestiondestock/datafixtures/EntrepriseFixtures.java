package com.momo.gestiondestock.datafixtures;

import com.momo.gestiondestock.model.Adresse;
import com.momo.gestiondestock.model.Category;
import com.momo.gestiondestock.model.Client;
import com.momo.gestiondestock.model.Entreprise;
import com.momo.gestiondestock.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@AllArgsConstructor
@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
@Order(2)
public class EntrepriseFixtures implements CommandLineRunner {

    private EntrepriseRepository entrepriseRepository;

    @Override
    public void run(String... args) throws Exception {
        Adresse adresse = new Adresse("scat urbam", "", "Dakar", "24000", "Senegal");
        entrepriseRepository.saveAll(Arrays.asList(
                new Entreprise("SYLLA BTP", "L'entreprise evolue dans le domaine du batiment", adresse, "15 000 000", "syllabtp@entreprise.com", "33771234567", "www.syllabtp.com", ""),
                new Entreprise("Expert IT", "L'entreprise evolue dans le domaine de la technologie", adresse, "25 000 000", "expertit@entreprise.com", "33771234569", "www.expertit.com", ""),
                new Entreprise("Light Africa", "L'entreprise evolue dans le domaine de l'energie", adresse, "85 000 000", "lightafrica@entreprise.com", "33771234560", "www.lightafrica.com", "")
        ));
    }
}


