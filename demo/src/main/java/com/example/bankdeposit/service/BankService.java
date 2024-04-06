package com.example.bankdeposit.service;

import com.example.bankdeposit.model.Bank;
import com.example.bankdeposit.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    private final BankRepository bankRepository;

    @Autowired
    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public Bank getBankById(Long bankId) {
        Optional<Bank> bankOptional = bankRepository.findById(bankId);
        return bankOptional.orElse(null);
    }

    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    public Bank createBank(Bank bank) {
        return bankRepository.save(bank);
    }

    public Bank updateBank(Long bankId, Bank bankDetails) {
        Optional<Bank> bankOptional = bankRepository.findById(bankId);
        if (bankOptional.isPresent()) {
            Bank existingBank = bankOptional.get();
            existingBank.setName(bankDetails.getName());
            existingBank.setBic(bankDetails.getBic());
            return bankRepository.save(existingBank);
        } else {
            return null;
        }
    }

    public boolean deleteBankById(Long bankId) {
        if (bankRepository.existsById(bankId)) {
            bankRepository.deleteById(bankId);
            return true;
        } else {
            return false;
        }
    }
}
