package com.balance.plan.application.dto.response;

import com.balance.plan.domain.entity.BalanceEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ResBalanceGetDto {
    private Balance balance;

    public static ResBalanceGetDto of(BalanceEntity entity) {
        return ResBalanceGetDto.builder()
                .balance(Balance.from(entity))
                .build();
    }

    @Getter
    @Builder
    public static class Balance{
        private Long balanceAmount;
        private LocalDateTime updatedAt;

        private static Balance from(BalanceEntity entity) {
            return Balance.builder()
                    .balanceAmount(entity.getBalanceAmount())
                    .updatedAt(entity.getUpdatedAt())
                    .build();
        }
    }
}
