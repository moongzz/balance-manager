package com.balance.plan.infrastructure.persistence;

import com.balance.plan.domain.entity.PlanEntity;
import com.balance.plan.domain.repository.PlanRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PlanJpaRepository extends JpaRepository<PlanEntity, Long>, PlanRepository,
        QuerydslPredicateExecutor<PlanEntity> {
}
