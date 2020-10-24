package org.example.dao;


import org.example.model.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDaoImpl implements TransactionDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Transaction transaction) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Transaction").list();
    }
}
