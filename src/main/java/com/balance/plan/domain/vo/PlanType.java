package com.balance.plan.domain.vo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PlanType {
    INCOME("수익"),
    EXPENSE("지출")
    ;

    private final String description;
}
