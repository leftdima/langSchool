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
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author leftdima
 */
@Entity
@Table(name = "order", catalog = "pizzastore", schema = "")
@NamedQueries({
    @NamedQuery(name = "OrderClient.findAll", query = "SELECT o FROM OrderClient o")})
public class OrderClient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "orderDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Column(name = "deliveryDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate;
    @Basic(optional = false)
    @Column(name = "delivered")
    private short delivered;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false )
    @Column(name = "orderPrice")
    private BigDecimal orderPrice;
    @Basic(optional = false)
    private short processed;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderClient")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Check> checkSet;
    @JoinColumn(name = "pizzeria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pizzeria pizzeria;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User user;

    public OrderClient() {
    }

    public OrderClient(Integer id) {
        this.id = id;
    }

    public OrderClient(Integer id, Date orderDate, short delivered, BigDecimal orderPrice) {
        this.id = id;
        this.orderDate = orderDate;
        this.delivered = delivered;
        this.orderPrice = orderPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public short getDelivered() {
        return delivered;
    }

    public void setDelivered(short delivered) {
        this.delivered = delivered;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Set<Check> getCheckSet() {
        return checkSet;
    }

    public void setCheckSet(Set<Check> checkSet) {
        this.checkSet = checkSet;
    }

    public Pizzeria getPizzeria() {
        return pizzeria;
    }

    public void setPizzeria(Pizzeria pizzeria) {
        this.pizzeria = pizzeria;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public short getProcessed() {
        return processed;
    }

    public void setProcessed(short processed) {
        this.processed = processed;
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
        if (!(object instanceof OrderClient)) {
            return false;
        }
        OrderClient other = (OrderClient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderClient{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", delivered=" + delivered +
                ", orderPrice=" + orderPrice +
                ", pizzeria=" + pizzeria +
                ", user=" + user +
                '}';
    }
}
