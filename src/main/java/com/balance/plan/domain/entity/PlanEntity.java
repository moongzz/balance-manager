package com.balance.plan.domain.entity;

import com.balance.plan.domain.vo.PlanStatus;
import com.balance.plan.domain.vo.PlanType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "p_plans")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_id")
    private Long id;

    @Column(nullable = false)
    private String details;

    @Column(nullable = false)
    private Long price;

    @Column
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PlanStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PlanType type;

    @Builder
    private PlanEntity(
            String details,
            Long price,
            LocalDateTime date,
            PlanStatus status,
            PlanType type
    ) {
        this.details = details;
        this.price = price;
        this.date = date;
        this.status = status;
        this.type = type;
    }

    public static PlanEntity create(
            String details,
            Long price,
            LocalDateTime date,
            PlanStatus status,
            PlanType type
    ) {
        return PlanEntity.builder()
                .details(details)
                .price(price)
                .date(date)
                .status(status)
                .type(type)
                .build();
    }

    public void update(
            String details,
            Long price,
            LocalDateTime date,
            PlanStatus status,
            PlanType type
    ){
        if (details != null) this.details = details;
        if (price != null) this.price = price;
        if (date != null) this.date = date;
        if (status != null) this.status = status;
        if (type != null) this.type = type;
    }

    public void complete() {
        this.status = PlanStatus.COMPLETED;
    }

    public void delete() {
        this.status = PlanStatus.DELETED;
    }

    public void canceled() {
        this.status = PlanStatus.PENDING;
    }

    public Long getSignedPrice() {
        return switch (this.type) {
            case INCOME -> price;
            case EXPENSE -> -price;
        };
    }
}


