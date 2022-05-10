package com.momo.gestiondestock.controller;


import com.momo.gestiondestock.controller.api.ArticleApi;
import com.momo.gestiondestock.dto.ArticleDto;
import com.momo.gestiondestock.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ArticleController implements ArticleApi {

    private ArticleService articleService;
    /* il existe 3 methode d'injection de dependance
        1) Field injection
            @Autowired
            private ArticleService articleService;
        2) Setter injection
            @Autowired
            public setArticleService getArticleService(){
                return articleService;
            }
        3) Constuctor injection
            @Autowired
            private ArticleController(){
            this.articleService = articleService;
             }
     */

    @Override
    public ArticleDto save(ArticleDto dto) {
        return articleService.save(dto);
    }

    @Override
    public ArticleDto findById(Integer id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDto findByCodearticle(String codearticle) {
        return articleService.findByCodearticle(codearticle);
    }

    @Override
    public ArticleDto findByDesignation(String designation) {
        return articleService.findByDesignation(designation);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public ArticleDto put(ArticleDto dto, Integer id) {
        return articleService.put(dto, id);
    }

    @Override
    public void delete(Integer id) {
        articleService.delete(id);
    }
}
