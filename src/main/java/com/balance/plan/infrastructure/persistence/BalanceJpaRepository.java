package com.balance.plan.infrastructure.persistence;

import com.balance.plan.domain.entity.BalanceEntity;
import com.balance.plan.domain.repository.BalanceRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BalanceJpaRepository extends JpaRepository<BalanceEntity, Long>, BalanceRepository,
        QuerydslPredicateExecutor<BalanceEntity> {
}
