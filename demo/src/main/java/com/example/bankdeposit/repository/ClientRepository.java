package com.example.bankdeposit.repository;

import com.example.bankdeposit.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    // Метод для поиска клиента по его имени
    Optional<Client> findByName(String name);

    // Метод для поиска клиентов по их краткому наименованию
    List<Client> findByShortNameContaining(String keyword);

    // Метод для поиска клиентов по их организационно-правовой форме
    List<Client> findByLegalForm(String legalForm);
}
