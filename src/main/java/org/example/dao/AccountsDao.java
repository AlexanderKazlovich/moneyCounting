package org.example.dao;

import org.example.model.Account;

import java.util.List;

public interface AccountsDao {
    List<Account> getAllAccounts();
    void deleteAccountById(int id);
    Account findById(int id);
    void update(Account account);
    Account findByName(String name);
}
