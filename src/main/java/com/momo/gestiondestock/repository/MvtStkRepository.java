package com.momo.gestiondestock.repository;

import com.momo.gestiondestock.model.Category;
import com.momo.gestiondestock.model.MvtStk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface MvtStkRepository extends JpaRepository <MvtStk, Long>{
    List<MvtStk> findAll();

    Optional<MvtStk> findById(Long id);

    Optional<MvtStk> findByDateMvt(Instant dateMvt);

    Optional<MvtStk> findByTypeMvt(String typeMvt);
}
