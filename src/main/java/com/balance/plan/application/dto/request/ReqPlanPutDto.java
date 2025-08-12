package com.balance.plan.application.dto.request;

import com.balance.plan.domain.entity.PlanEntity;
import com.balance.plan.domain.vo.PlanStatus;
import com.balance.plan.domain.vo.PlanType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ReqPlanPutDto {
    private Plan plan;

    @Getter
    @Builder
    public static class Plan {
        private String details;
        private Long price;
        private LocalDateTime date;
        private PlanStatus status;
        private PlanType type;

        public void update(PlanEntity entity) {
            entity.update(details, price, date, status, type);
        }
    }
}
