package com.momo.gestiondestock.datafixtures;

import com.momo.gestiondestock.model.Adresse;
import com.momo.gestiondestock.model.Category;
import com.momo.gestiondestock.model.Client;
import com.momo.gestiondestock.model.CommandeClient;
import com.momo.gestiondestock.repository.ArticleRepository;
import com.momo.gestiondestock.repository.CategoryRepository;
import com.momo.gestiondestock.repository.ClientRepository;
import com.momo.gestiondestock.repository.CommandeClientRepository;
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
public class CommandeClientFixtures implements CommandLineRunner {

    private CommandeClientRepository commandeClientRepository;
    private  ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {
        commandeClientRepository.saveAll(Arrays.asList(
                new CommandeClient("CC200", clientRepository.findAll().get(0)),
                new CommandeClient("CC300", clientRepository.findAll().get(1)),
                new CommandeClient("CC400", clientRepository.findAll().get(2)),
                new CommandeClient("CC500", clientRepository.findAll().get(3))
                ));
    }
}

