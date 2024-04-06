package com.example.bankdeposit.service;

import com.example.bankdeposit.model.Deposit;
import com.example.bankdeposit.repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepositService {

    private final DepositRepository depositRepository;

    @Autowired
    public DepositService(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }

    public Deposit getDepositById(Long depositId) {
        Optional<Deposit> depositOptional = depositRepository.findById(depositId);
        return depositOptional.orElse(null);
    }

    public List<Deposit> getAllDeposits() {
        return depositRepository.findAll();
    }

    public Deposit createDeposit(Deposit deposit) {
        return depositRepository.save(deposit);
    }

    public Deposit updateDeposit(Long depositId, Deposit depositDetails) {
        Optional<Deposit> depositOptional = depositRepository.findById(depositId);
        if (depositOptional.isPresent()) {
            Deposit existingDeposit = depositOptional.get();
            existingDeposit.setClient(depositDetails.getClient());
            existingDeposit.setBank(depositDetails.getBank());
            existingDeposit.setOpeningDate(depositDetails.getOpeningDate());
            existingDeposit.setInterest(depositDetails.getInterest());
            existingDeposit.setTermMonths(depositDetails.getTermMonths());
            return depositRepository.save(existingDeposit);
        } else {
            return null;
        }
    }

    public boolean deleteDepositById(Long depositId) {
        if (depositRepository.existsById(depositId)) {
            depositRepository.deleteById(depositId);
            return true;
        } else {
            return false;
        }
    }
}
