package com.balance.plan.application.service;

import com.balance.plan.application.dto.response.ResBalanceGetDto;
import com.balance.plan.domain.entity.BalanceEntity;
import com.balance.plan.domain.repository.BalanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BalanceService {
    private final BalanceRepository repository;

    public ResBalanceGetDto getBy(Long id) {
        BalanceEntity entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않음"));
        return ResBalanceGetDto.of(entity);
    }

    public void update(Long id, Long price) {
        BalanceEntity entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않음"));
        entity.update(price);
    }
}
