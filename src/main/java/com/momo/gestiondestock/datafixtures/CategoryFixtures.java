package com.momo.gestiondestock.datafixtures;

import com.momo.gestiondestock.model.Category;
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
public class CategoryFixtures implements CommandLineRunner {

    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
 categoryRepository.saveAll(Arrays.asList(
                 new Category("CAT2020", "Meubles"),
                 new Category("CAT2021", "Mode"),
                 new Category("CAT2022", "Electromenagere"),
                 new Category("CAT2023", "Cosmetiques")

         ));
    }
}
