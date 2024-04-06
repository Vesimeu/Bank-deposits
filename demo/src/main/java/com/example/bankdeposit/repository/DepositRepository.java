package com.example.bankdeposit.repository;

import com.example.bankdeposit.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {

    // Метод для поиска вкладов, открытых после указанной даты
    List<Deposit> findByOpeningDateAfter(LocalDate date);

    // Метод для поиска вкладов клиента по его ID
    List<Deposit> findByClientId(Long clientId);

    // Метод для поиска вкладов банка по его ID
    List<Deposit> findByBankId(Long bankId);
}
