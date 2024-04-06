package com.example.bankdeposit.controller;

import com.example.bankdeposit.model.Bank;
import com.example.bankdeposit.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banks")
public class BankController {

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/{bankId}")
    public ResponseEntity<Bank> getBankById(@PathVariable Long bankId) {
        Bank bank = bankService.getBankById(bankId);
        if (bank != null) {
            return ResponseEntity.ok(bank);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Bank> createBank(@RequestBody Bank bank) {
        Bank createdBank = bankService.createBank(bank);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBank);
    }

    @PutMapping("/{bankId}")
    public ResponseEntity<Bank> updateBank(@PathVariable Long bankId, @RequestBody Bank bankDetails) {
        Bank updatedBank = bankService.updateBank(bankId, bankDetails);
        if (updatedBank != null) {
            return ResponseEntity.ok(updatedBank);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{bankId}")
    public ResponseEntity<?> deleteBank(@PathVariable Long bankId) {
        boolean deleted = bankService.deleteBankById(bankId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
