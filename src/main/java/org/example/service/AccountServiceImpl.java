package org.example.service;

import org.example.dao.AccountsDao;
import org.example.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {
    private AccountsDao accountsDao;

    @Autowired
    public void setAccountsDao(AccountsDao accountsDao) {
        this.accountsDao = accountsDao;
    }

    @Override
    @Transactional
    public List<Account> getAllAccounts() {
        return accountsDao.getAllAccounts();
    }

    @Override
    @Transactional
    public void deleteAccountById(int id) {
        accountsDao.deleteAccountById(id);
    }

    @Override
    @Transactional
    public Account findById(int id) {
        return accountsDao.findById(id);
    }

    @Override
    @Transactional
    public void updateExpense(Account account, Integer exp) {
        Integer realBalance = account.getBalance() - exp;
        Account acc = new Account(account.getId(), account.getName(), realBalance);
        accountsDao.update(acc);

    }

    @Override
    @Transactional
    public void updateIncome(Account account, Integer inc) {
        Integer realBalance = account.getBalance() + inc;
        Account acc = new Account(account.getId(), account.getName(), realBalance);
        accountsDao.update(acc);
    }

    @Override
    @Transactional
    public Account findByName(String name) {
        return accountsDao.findByName(name);
    }
}
