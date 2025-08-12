package com.balance.plan.application.service;

import com.balance.plan.application.dto.request.ReqPlanPostDto;
import com.balance.plan.application.dto.request.ReqPlanPutDto;
import com.balance.plan.application.dto.response.ResPlanGetDto;
import com.balance.plan.domain.entity.PlanEntity;
import com.balance.plan.domain.repository.PlanRepository;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PlanService {

    private final PlanRepository repository;
    private final BalanceService balanceService;

    @Transactional
    public void postBy(ReqPlanPostDto dto) {
        PlanEntity entity = dto.getPlan().toEntityBy();
        repository.save(entity);
    }

    public ResPlanGetDto getBy(Predicate predicate, Pageable pageable) {
        Page<PlanEntity> planEntityPage = repository.findAll(predicate, pageable);
        return ResPlanGetDto.of(planEntityPage);
    }

    @Transactional
    public void putBy(Long id, ReqPlanPutDto dto) {
        dto.getPlan().update(findBy(id));
    }

    @Transactional
    public void deleteBy(Long id) {
        findBy(id).delete();
    }

    @Transactional
    public void completedBy(Long id) {
        PlanEntity entity = findBy(id);
        balanceService.update(1L, entity.getSignedPrice());
        entity.complete();
    }

    @Transactional
    public void canceledBy(Long id) {
        PlanEntity entity = findBy(id);
        balanceService.update(1L, -entity.getSignedPrice());
        entity.canceled();
    }

    private PlanEntity findBy(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 Plan 없음"));
    }

}
