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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author leftdima
 */
@Entity
@Table(name = "pizza", catalog = "pizzastore", schema = "")
@NamedQueries({
    @NamedQuery(name = "Pizza.findAll", query = "SELECT p FROM Pizza p")})
public class Pizza implements Serializable {

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
    @Column(name = "cost")
    private BigDecimal cost;
    @Basic(optional = false)
    @Column(name = "urlImage")
    private String urlImage;
    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "pizzaSet")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Ingredient> ingredientSet;
    @JoinColumn(name = "size", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SizePizza size1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pizza1")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Check> checkSet;

    public Pizza() {
    }

    public Pizza(Integer id) {
        this.id = id;
    }

    public Pizza(Integer id, String name, BigDecimal cost, String urlImage, String description) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.urlImage = urlImage;
        this.description = description;
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

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Ingredient> getIngredientSet() {
        return ingredientSet;
    }

    public void setIngredientSet(Set<Ingredient> ingredientSet) {
        this.ingredientSet = ingredientSet;
    }

    public SizePizza getSize1() {
        return size1;
    }

    public void setSize1(SizePizza size1) {
        this.size1 = size1;
    }

    public Set<Check> getCheckSet() {
        return checkSet;
    }

    public void setCheckSet(Set<Check> checkSet) {
        this.checkSet = checkSet;
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
        if (!(object instanceof Pizza)) {
            return false;
        }
        Pizza other = (Pizza) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name + " " + size1.getName();
    }
}
