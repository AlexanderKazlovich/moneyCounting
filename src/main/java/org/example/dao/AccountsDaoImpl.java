package org.example.dao;

import org.example.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class AccountsDaoImpl implements AccountsDao{
    private static final Logger logger = LoggerFactory.getLogger(AccountsDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Account> getAllAccounts() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Account ").list();
    }

    @Override
    public void deleteAccountById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Account account = session.load(Account.class, id);
        session.delete(account);
        session.flush();
    }

    @Override
    public Account findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Account.class, id);
    }

    @Override
    public void update(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.update(account);
    }

    @Override
    public Account findByName(String nameAcc) {
        Query query = sessionFactory.getCurrentSession()
                      .createQuery("from Account  where name = :nameAcc");
        query.setParameter("nameAcc", nameAcc);
        Account acc = (Account) query.uniqueResult();
        return acc;
    }
}
