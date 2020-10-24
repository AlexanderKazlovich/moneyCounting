package org.example.service;

import org.example.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
    void deleteAccountById(int id);
    Account findById(int id);
    void updateExpense(Account account, Integer exp);
    void updateIncome(Account account, Integer inc);
    Account findByName(String name);
}
