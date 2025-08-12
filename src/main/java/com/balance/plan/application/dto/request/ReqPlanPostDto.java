package com.balance.plan.application.dto.request;

import com.balance.plan.domain.entity.PlanEntity;
import com.balance.plan.domain.vo.PlanStatus;
import com.balance.plan.domain.vo.PlanType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ReqPlanPostDto {
    private Plan plan;

    @Builder
    @Getter
    public static class Plan {
        private String details;
        private Long price;
        private LocalDateTime date;
        private PlanType type;

        public PlanEntity toEntityBy() {
            return PlanEntity.create(details, price, date, PlanStatus.PENDING, type);
        }
    }
}
