package com.momo.gestiondestock.datafixtures;

import com.momo.gestiondestock.model.Article;
import com.momo.gestiondestock.repository.ArticleRepository;
import com.momo.gestiondestock.repository.CategoryRepository;
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
public class ArticlesFixtures implements CommandLineRunner {

    private ArticleRepository articleRepository;
    private CategoryRepository categoryRepository;


    @Override
    public void run(String... args) throws Exception {

        articleRepository.saveAll(Arrays.asList(
                new Article("A2020", "Micro Onde", "100 000", "0,18", "118 000", "", categoryRepository.findAll().get(0)),
                new Article("A2021", "Machine à laver", "150 000", "0,18", "126 000", "", categoryRepository.findAll().get(0))
        ));

    }
}
