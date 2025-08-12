package com.balance.plan.application.dto.response;

import com.balance.plan.domain.entity.PlanEntity;
import com.balance.plan.domain.vo.PlanStatus;
import com.balance.plan.domain.vo.PlanType;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.web.PagedModel;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class ResPlanGetDto {
    private PlanPage planPage;

    public static ResPlanGetDto of (Page<PlanEntity> planEntityPage) {
        return ResPlanGetDto.builder()
                .planPage(new PlanPage(planEntityPage))
                .build();
    }

    @Getter
    public static class PlanPage extends PagedModel<PlanPage.Plan> {
        public PlanPage(Page<PlanEntity> planEntityPage) {
            super(
                    new PageImpl<>(
                            Plan.from(planEntityPage.getContent()),
                            planEntityPage.getPageable(),
                            planEntityPage.getTotalElements()
                    )
            );
        }

        @Getter
        @Builder
        public static class Plan {
            private  Long id;
            private String details;
            private Long price;
            private LocalDateTime date;
            private PlanStatus status;
            private PlanType type;

            public static List<Plan> from(List<PlanEntity> planEntityList) {
                return planEntityList.stream()
                        .map(Plan::from)
                        .toList();
            }

            public static Plan from(PlanEntity entity) {
                return Plan.builder()
                        .id(entity.getId())
                        .details(entity.getDetails())
                        .price(entity.getPrice())
                        .date(entity.getDate())
                        .status(entity.getStatus())
                        .type(entity.getType())
                        .build();
            }
        }
    }
}
