package com.example.bankdeposit.controller;

import com.example.bankdeposit.model.Deposit;
import com.example.bankdeposit.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deposits")
public class DepositController {

    private final DepositService depositService;

    @Autowired
    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @GetMapping("/{depositId}")
    public ResponseEntity<Deposit> getDepositById(@PathVariable Long depositId) {
        Deposit deposit = depositService.getDepositById(depositId);
        if (deposit != null) {
            return ResponseEntity.ok(deposit);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Deposit> createDeposit(@RequestBody Deposit deposit) {
        Deposit createdDeposit = depositService.createDeposit(deposit);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDeposit);
    }

    @PutMapping("/{depositId}")
    public ResponseEntity<Deposit> updateDeposit(@PathVariable Long depositId, @RequestBody Deposit depositDetails) {
        Deposit updatedDeposit = depositService.updateDeposit(depositId, depositDetails);
        if (updatedDeposit != null) {
            return ResponseEntity.ok(updatedDeposit);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{depositId}")
    public ResponseEntity<?> deleteDeposit(@PathVariable Long depositId) {
        boolean deleted = depositService.deleteDepositById(depositId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
