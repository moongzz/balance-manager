package com.balance.plan.domain.repository;

import com.balance.plan.domain.entity.PlanEntity;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PlanRepository {
    PlanEntity save(PlanEntity planEntity);

    Page<PlanEntity> findAll(Predicate predicate, Pageable pageable);

    Optional<PlanEntity> findById(Long id);
}
