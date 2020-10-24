package org.example.service;

import org.example.model.Transaction;

import java.util.List;

public interface TransactionService {
    void add(Transaction transaction);
    List<Transaction> getAllTransactions();
}
