package com.momo.gestiondestock.datafixtures;

import com.momo.gestiondestock.model.Adresse;
import com.momo.gestiondestock.model.Category;
import com.momo.gestiondestock.model.Client;
import com.momo.gestiondestock.repository.ArticleRepository;
import com.momo.gestiondestock.repository.CategoryRepository;
import com.momo.gestiondestock.repository.ClientRepository;
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
public class ClientFixtures implements CommandLineRunner {

    private ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {
        Adresse adresse = new Adresse("scat urbam", "", "Dakar", "24000", "Senegal");
        clientRepository.saveAll(Arrays.asList(
                 new Client("Omar", "Faye", adresse, "", "omar@faye.com", "771234567"),
                new Client("Asna", "Gueye", adresse, "", "asna@gueye.com", "771234568"),
                new Client("Cbag", "Goudie", adresse, "", "cbag@cbag.com", "771234569"),
                new Client("Fadilou", "Sy", adresse, "", "fadilou@sy.com", "771234566")
         ));
    }
}

