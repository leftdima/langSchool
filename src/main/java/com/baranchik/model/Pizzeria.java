/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baranchik.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author leftdima
 */
@Entity
@Table(name = "pizzeria", catalog = "pizzastore", schema = "")
@NamedQueries({
    @NamedQuery(name = "Pizzeria.findAll", query = "SELECT p FROM Pizzeria p")})
public class Pizzeria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "address", referencedColumnName = "id")
    @OneToOne
    private Address address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pizzeria")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<OrderClient> orderClientSet;

    public Pizzeria() {
    }

    public Pizzeria(Integer id) {
        this.id = id;
    }

    public Pizzeria(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<OrderClient> getOrderClientSet() {
        return orderClientSet;
    }

    public void setOrderClientSet(Set<OrderClient> orderClientSet) {
        this.orderClientSet = orderClientSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pizzeria)) {
            return false;
        }
        Pizzeria other = (Pizzeria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pizzeria{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
