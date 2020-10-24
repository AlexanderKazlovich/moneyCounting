package org.example.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trans")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fromAcc")
    private String fromAcc;

    @Column(name = "toAcc")
    private String toAcc;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "date")
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromAcc() {
        return fromAcc;
    }

    public void setFromAcc(String fromAcc) {
        this.fromAcc = fromAcc;
    }

    public String getToAcc() {
        return toAcc;
    }

    public void setToAcc(String toAcc) {
        this.toAcc = toAcc;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Transaction(String fromAcc, String toAcc, int quantity, Date date) {
        this.fromAcc = fromAcc;
        this.toAcc = toAcc;
        this.quantity = quantity;
        this.date = date;
    }

    public Transaction() {
    }
}
