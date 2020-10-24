package org.example.service;

import org.example.dao.TransactionDao;
import org.example.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private TransactionDao transactionDao;

    @Autowired
    public void setAccountsDao(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    @Override
    @Transactional
    public void add(Transaction transaction) {
        transactionDao.add(transaction);
    }

    @Override
    @Transactional
    public List<Transaction> getAllTransactions() {
        return transactionDao.getAllTransactions();
    }
}
