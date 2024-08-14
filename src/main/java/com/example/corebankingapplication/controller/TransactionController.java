package com.example.corebankingapplication.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/transactions")
public class TransactionController {

    Logger logger = LoggerFactory.getLogger("TransactionController.class");

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository accountRepository;

    @RequestMapping("/list")
    public String showTrans(Model model) {
        List<Transaction> tranList = transactionRepository.findAll();
        model.addAttribute("transactions", tranList);
        model.addAttribute("activePage", "transactions"); // Set the active page
        logger.info("Successfully fetched {} transactions", tranList.size()); // log messages
        return "showtransac";
    }

    @RequestMapping("/search")
    public String searchAcct(@RequestParam("term") String keyword, Model model) {
        List<Transaction> searchList = transactionRepository.search(keyword);
        model.addAttribute("transactions", searchList);
        model.addAttribute("activePage", "transactions"); // Set the active page
        logger.info("Search completed, found {} transactions with keyword: {}", searchList.size(), keyword);
        // logger.info("Search completed with keyword '{}', found {} transactions", keyword, searchList.size());
        return "showtransac";
    }
    
    @RequestMapping("/add")
    public String addTrans(Model model) {
        List<Account> accounts = accountRepository.findAll();
        List<String> transactionTypes = List.of("Deposits", "Withrawal");
        model.addAttribute("accounts", accounts);
        model.addAttribute("transactionTypes", transactionTypes);
        model.addAttribute("activePage", "transactions"); // Set the active page
        logger.info("Preparing to add new transaction. Accounts and transaction types loaded.");
        return "addtransac";
    }

    @RequestMapping("/save")
    public String saveRecord(
            @RequestParam("tid") long tid,
            @RequestParam("ttype") String ttype,
            @RequestParam("tdate") LocalDate tdate,
            @RequestParam("tamt") double tamt,
            @RequestParam("aacct") Account account) {
        Transaction newTransaction = new Transaction(tid, ttype, tdate, tamt, account);
        transactionRepository.save(newTransaction);
        logger.info("Saved new transaction with ID: {}, Type: {}, Date: {}, Amount: {}, Account ID: {}", tid, ttype, tdate, tamt, account.getId());
        return "redirect:/transactions/list";
    }
}