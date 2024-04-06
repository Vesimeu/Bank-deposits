package com.example.bankdeposit.repository;

import com.example.bankdeposit.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

    // Метод для поиска банка по его наименованию
    Optional<Bank> findByName(String name);

    // Метод для поиска банков по их БИК
    Optional<Bank> findByBic(String bic);
}
