package com.example.corebankingapplication.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private Long id;
=======
    private long id;
>>>>>>> ba02dbe2077813465877e3d1486d51783a77acf9
    private String accountType;
    private double balance;
    private LocalDate openDate;
    @ManyToOne
    private Customer customer;
<<<<<<< HEAD

    public Account(String accountType, double balance, LocalDate openDate, Customer customer) {
        this.accountType = accountType;
        this.balance = balance;
        this.openDate = openDate;
        this.customer = customer;
    }
=======
>>>>>>> ba02dbe2077813465877e3d1486d51783a77acf9
}
