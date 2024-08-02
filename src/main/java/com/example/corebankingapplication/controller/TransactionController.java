package com.example.corebankingapplication.controller;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.corebankingapplication.model.Account;
import com.example.corebankingapplication.model.Transaction;
import com.example.corebankingapplication.repo.AccountRepository;
import com.example.corebankingapplication.repo.TransactionRepository;


@Controller
@RequestMapping("/transaction") // prefix to endpoints on methods /trans/list
public class TransactionController {
  
  @Autowired
  TransactionRepository transactionRepository;

  @Autowired
  AccountRepository accountRepository;


    @RequestMapping("/list")
    public String showTrans(Model model) {
        List<Transaction> transList = transactionRepository.findAll();
        model.addAttribute("transaction", transList);
        return "showtransac";
    }

    @RequestMapping("/search")
    public String searchTrans(@RequestParam("term") String keyword, Model model) {
        List<Transaction> searchList = transactionRepository.search(keyword);
        model.addAttribute("transaction", searchList);
        return "showtransac";
    }

    @RequestMapping("/add")
    public String addTrans(Model model) {
        List<Account> accounts = accountRepository.findAll();
        List<String> transactionTypes = List.of("Deposits", "Withrawal");
        model.addAttribute("accounts", accounts);
        model.addAttribute("transactionTypes", transactionTypes);
        return "addtransac";
    }
    
    @RequestMapping("/save")
    public String saveRecord(
            @RequestParam("transtype") String ttype,
            @RequestParam("transdate") LocalDate tdate,
            @RequestParam("transamt") double tamt,
            @RequestParam("aacct") Account account) {
        Transaction newTransaction = new Transaction();
        transactionRepository.save(newTransaction);
        return "redirect:/transaction/list";
    }
    
    

}
