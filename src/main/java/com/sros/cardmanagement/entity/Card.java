package com.sros.cardmanagement.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "card_number", nullable = false, length = 16)
    private String cardNumber;

    @Column(name = "type", nullable = false, length = 6)
    private String type;

    @Column(name = "daily_limit", nullable = false)
    private Double dailyLimit;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @Column(name = "exp_date", nullable = false)
    private Date expDate;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Card() {
    }

    public Card(String cardNumber, String type, Double dailyLimit, Double balance, Date expDate, String status, User user) {
        this.cardNumber = cardNumber;
        this.type = type;
        this.dailyLimit = dailyLimit;
        this.balance = balance;
        this.expDate = expDate;
        this.status = status;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getDailyLimit() {
        return dailyLimit;
    }

    public void setDailyLimit(Double dailyLimit) {
        this.dailyLimit = dailyLimit;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
