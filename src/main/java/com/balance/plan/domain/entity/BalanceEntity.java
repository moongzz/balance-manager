package com.balance.plan.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "p_balance")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BalanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "balance_id")
    private Long id;

    @Column(name = "balance_amount", nullable = false)
    private Long balanceAmount;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public void update(
            Long price
    ) {
        this.balanceAmount += price;
        updatedAt = LocalDateTime.now();
    }
}

/*
SQL로 직접 초기값 넣기
INSERT INTO p_balance (balance_amount, updated_at)
VALUES (0, NOW());
 */