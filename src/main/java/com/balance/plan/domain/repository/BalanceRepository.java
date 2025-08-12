package com.balance.plan.domain.repository;

import com.balance.plan.domain.entity.BalanceEntity;

import java.util.Optional;

public interface BalanceRepository {
    Optional<BalanceEntity> findById(Long id);
}
