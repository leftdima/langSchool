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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "address", catalog = "pizzastore", schema = "")
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "locality")
    private String locality;
    @Basic(optional = false)
    @Column(name = "street")
    private String street;
    @Basic(optional = false)
    @Column(name = "house")
    private int house;
    @Column(name = "apartment")
    private Integer apartment;
    @OneToOne(mappedBy = "address")
    private Pizzeria pizzeria;
    @OneToMany(mappedBy = "address")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<User> userSet;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;

    public Address() {
    }

    public Address(Integer id) {
        this.id = id;
    }

    public Address(Integer id, String locality, String street, int house) {
        this.id = id;
        this.locality = locality;
        this.street = street;
        this.house = house;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public Integer getApartment() {
        return apartment;
    }

    public void setApartment(Integer apartment) {
        this.apartment = apartment;
    }

    public Pizzeria getPizzeria() {
        return pizzeria;
    }

    public void setPizzeria(Pizzeria pizzeria) {
        this.pizzeria = pizzeria;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
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
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public String getFullAddress(){
        if (apartment == null){
            return "Улица " + street + " д." + house + " " + locality;
        } else {
            return "Улица " + street + " д." + house + " кв." + apartment + " " + locality;
        }
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", locality='" + locality + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", apartment=" + apartment +
                ", pizzeria=" + pizzeria +
                ", userSet=" + userSet +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
