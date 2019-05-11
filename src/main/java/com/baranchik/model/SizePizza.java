/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baranchik.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author leftdima
 */
@Entity
@Table(name = "size", catalog = "pizzastore", schema = "")
@NamedQueries({
    @NamedQuery(name = "SizePizza.findAll", query = "SELECT s FROM SizePizza s")})
public class SizePizza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "coefficient")
    private BigDecimal coefficient;
    @Basic(optional = false)
    @Column(name = "weight")
    private int weight;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "size1")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Pizza> pizzaSet;

    public SizePizza() {
    }

    public SizePizza(Integer id) {
        this.id = id;
    }

    public SizePizza(Integer id, String name, BigDecimal coefficient, int weight) {
        this.id = id;
        this.name = name;
        this.coefficient = coefficient;
        this.weight = weight;
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

    public BigDecimal getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(BigDecimal coefficient) {
        this.coefficient = coefficient;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Set<Pizza> getPizzaSet() {
        return pizzaSet;
    }

    public void setPizzaSet(Set<Pizza> pizzaSet) {
        this.pizzaSet = pizzaSet;
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
        if (!(object instanceof SizePizza)) {
            return false;
        }
        SizePizza other = (SizePizza) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SizePizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coefficient=" + coefficient +
                ", weight=" + weight +
                '}';
    }
}
