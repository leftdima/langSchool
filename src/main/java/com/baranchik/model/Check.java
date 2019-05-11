/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baranchik.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author leftdima
 */
@Entity
@Table(name = "check", catalog = "pizzastore", schema = "")
@NamedQueries({
    @NamedQuery(name = "Check.findAll", query = "SELECT c FROM Check c")})
public class Check implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CheckPK checkPK;
    @Basic(optional = false)
    @Column(name = "amount")
    private int amount;
    @JoinColumn(name = "order", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OrderClient orderClient;
    @JoinColumn(name = "pizza", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pizza pizza1;

    public Check() {
    }

    public Check(CheckPK checkPK) {
        this.checkPK = checkPK;
    }

    public Check(CheckPK checkPK, int amount) {
        this.checkPK = checkPK;
        this.amount = amount;
    }

    public Check(int order, int pizza) {
        this.checkPK = new CheckPK(order, pizza);
    }

    public CheckPK getCheckPK() {
        return checkPK;
    }

    public void setCheckPK(CheckPK checkPK) {
        this.checkPK = checkPK;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public OrderClient getOrderClient() {
        return orderClient;
    }

    public void setOrderClient(OrderClient orderClient) {
        this.orderClient = orderClient;
    }

    public Pizza getPizza1() {
        return pizza1;
    }

    public void setPizza1(Pizza pizza1) {
        this.pizza1 = pizza1;
    }

    private String getInfoOfAmount() {
        return " Штук: " + amount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (checkPK != null ? checkPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Check)) {
            return false;
        }
        Check other = (Check) object;
        if ((this.checkPK == null && other.checkPK != null) || (this.checkPK != null && !this.checkPK.equals(other.checkPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pizza1.toString() + getInfoOfAmount() + "\n";
    }
}
