package com.example.bankdeposit.model;

import java.time.LocalDate;

public class Deposit {
    private Long id;
    private Client client;
    private Bank bank;
    private LocalDate openingDate;
    private double interestRate;
    private int durationMonths;

    // Конструкторы, геттеры и сеттеры

    public Deposit() {
    }

    public Deposit(Long id, Client client, Bank bank, LocalDate openingDate, double interestRate, int durationMonths) {
        this.id = id;
        this.client = client;
        this.bank = bank;
        this.openingDate = openingDate;
        this.interestRate = interestRate;
        this.durationMonths = durationMonths;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
    }
}
