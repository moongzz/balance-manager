package com.balance.plan.presentation.controller;

import com.balance.plan.application.dto.request.ReqPlanPostDto;
import com.balance.plan.application.dto.request.ReqPlanPutDto;
import com.balance.plan.application.dto.response.ResPlanGetDto;
import com.balance.plan.application.service.PlanService;
import com.balance.plan.domain.entity.PlanEntity;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plans")
public class PlanController {
    private final PlanService service;

    @PostMapping
    public ResponseEntity<Void> postBy(
            @RequestBody ReqPlanPostDto dto
    ) {
        service.postBy(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<ResPlanGetDto> getBy(
            @QuerydslPredicate(root = PlanEntity.class) Predicate predicate,
            @PageableDefault(sort = "date", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        ResPlanGetDto response = service.getBy(predicate, pageable);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putBy(
            @PathVariable Long id,
            @RequestBody ReqPlanPutDto dto
    ) {
        service.putBy(id, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBy(
            @PathVariable Long id
    ) {
        service.deleteBy(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/completed")
    public ResponseEntity<Void> completedBy(
            @PathVariable Long id
    ) {
        service.completedBy(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/canceled")
    public ResponseEntity<Void> canceledBy(
            @PathVariable Long id
    ) {
        service.canceledBy(id);
        return ResponseEntity.ok().build();
    }
}
