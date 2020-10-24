package org.example.dao;

import org.example.model.Transaction;

import java.util.List;

public interface TransactionDao {
    void add(Transaction transaction);
    List<Transaction> getAllTransactions();
}
