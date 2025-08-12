package com.balance.plan.presentation.controller;

import com.balance.plan.application.dto.response.ResBalanceGetDto;
import com.balance.plan.application.service.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/balances")
public class BalanceController {
    private final BalanceService service;

    @GetMapping("/{id}")
    public ResponseEntity<ResBalanceGetDto> getBy(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(service.getBy(id));
    }
}
