package com.example.bankdeposit.model;

public class Client {
    private Long id;
    private String name;
    private String shortName;
    private String address;
    private String legalForm;

    // Конструкторы, геттеры и сеттеры

    public Client() {
    }

    public Client(Long id, String name, String shortName, String address, String legalForm) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.address = address;
        this.legalForm = legalForm;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLegalForm() {
        return legalForm;
    }

    public void setLegalForm(String legalForm) {
        this.legalForm = legalForm;
    }
}
