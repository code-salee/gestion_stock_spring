package com.momo.gestiondestock.service.impl;

import com.momo.gestiondestock.dto.ArticleDto;
import com.momo.gestiondestock.exception.EntityNotFoundException;
import com.momo.gestiondestock.exception.ErrorCodes;
import com.momo.gestiondestock.exception.InvalidEntityException;
import com.momo.gestiondestock.model.Article;
import com.momo.gestiondestock.model.Category;
import com.momo.gestiondestock.repository.ArticleRepository;
import com.momo.gestiondestock.repository.CategoryRepository;
import com.momo.gestiondestock.service.ArticleService;
import com.momo.gestiondestock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;
    private CategoryRepository categoryRepository;

    private Date date = new Date();
    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository, CategoryRepository categoryRepository){
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        Random random = new Random();
        String code = "ART" + (random.nextInt((9999 - 1000) + 1) + 1);
        dto.setCodearticle(code);
        List<String> errors = ArticleValidator.Articlevalidate(dto);
        if(!errors.isEmpty()){
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("L'article n'est valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }
        return ArticleDto.fromEntity(
                articleRepository.save(
                        ArticleDto.toEntity(dto)
                )
        );
    }

    @Override
    public ArticleDto findById(Integer id) {
        if(id == null){
            log.error("Article ID is null");
            return null;
        }
        Optional<Article> article = articleRepository.findById(id);
        ArticleDto dto = ArticleDto.fromEntity(article.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException(
                        "Un article avec cet: " + id + " n'existe pas",
                        ErrorCodes.ARTICLE_NOT_FOUND
                )
                );
    }

    @Override
    public ArticleDto findByCodearticle(String codearticle) {
        if (!StringUtils.hasLength(codearticle)){
            log.error("Code article is not valid");
            return null;
        }
        Optional<Article> article = articleRepository.findByCodearticle(codearticle);
        ArticleDto dto = ArticleDto.fromEntity(article.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException(
                        "Un article avec cet code: " + codearticle + " n'existe pas",
                        ErrorCodes.ARTICLE_NOT_FOUND
                )
        );
    }

    @Override
    public ArticleDto findByDesignation(String designation) {
        if (!StringUtils.hasLength(designation)){
            log.error("Designation article is not valid");
            return null;
        }

        Optional<Article> article = articleRepository.findByDesignation(designation);
        ArticleDto dto = ArticleDto.fromEntity(article.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException(
                        "Un article avec cette designation: " + designation + " n'existe pas",
                        ErrorCodes.ARTICLE_NOT_FOUND
                )
        );
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                    .collect(Collectors.toList());
    }

    @Override
    public ArticleDto put(ArticleDto dto, Integer id) {
        if (id == null) return null;
        Article article = articleRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(
                            "Aucun article avec l'ID = " + id + " ne se trouve dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND));
            article.setCodearticle(dto.getCodearticle());
            article.setDesignation(dto.getDesignation());
            article.setPrixunitaireht(dto.getPrixunitaireht());
            article.setTauxtva(dto.getTauxtva());
            article.setPrixunitairettc(dto.getPrixunitairettc());
            article.setModificationDate(date);
            article.setPhoto(dto.getPhoto());
            if(categoryRepository.findById(dto.getCategory().getId()).isPresent())
                article.setCategory(categoryRepository.findById(dto.getCategory().getId()).get());


        //ArticleDto articleDto = ArticleDto.fromEntity(article);
        ArticleDto articleDto = ArticleDto.fromEntity(article);
        List<String> errors = ArticleValidator.Articlevalidate(dto);
        if(!errors.isEmpty()){
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("L'article n'est valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }
        articleRepository.flush();
        return articleDto;
    }


    @Override
    public void delete(Integer id) {
    if (id == null){
        log.error("Article ID is null");
        return;
    }
    articleRepository.deleteById(id);
    }
}
