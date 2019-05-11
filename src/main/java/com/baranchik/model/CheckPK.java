/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baranchik.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author leftdima
 */
@Embeddable
public class CheckPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "order")
    private int order;
    @Basic(optional = false)
    @Column(name = "pizza")
    private int pizza;

    public CheckPK() {
    }

    public CheckPK(int order, int pizza) {
        this.order = order;
        this.pizza = pizza;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getPizza() {
        return pizza;
    }

    public void setPizza(int pizza) {
        this.pizza = pizza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) order;
        hash += (int) pizza;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CheckPK)) {
            return false;
        }
        CheckPK other = (CheckPK) object;
        if (this.order != other.order) {
            return false;
        }
        if (this.pizza != other.pizza) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CheckPK{" +
                "order=" + order +
                ", pizza=" + pizza +
                '}';
    }
}
