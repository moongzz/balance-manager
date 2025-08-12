package com.balance.plan.domain.vo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PlanStatus {
    PENDING("미완료"),
    COMPLETED("완료"),
//    CANCELED("취소"),
    DELETED("삭제")
    ;

    private final String description;
}
