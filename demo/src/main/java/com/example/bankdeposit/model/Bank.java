package com.example.bankdeposit.model;

public class Bank {
    private Long id;
    private String name;
    private String bic;

    // Конструкторы, геттеры и сеттеры

    public Bank() {
    }

    public Bank(Long id, String name, String bic) {
        this.id = id;
        this.name = name;
        this.bic = bic;
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

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }
}
