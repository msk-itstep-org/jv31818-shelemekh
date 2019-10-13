package org.itstep.msk.app.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( name = "name_product",nullable = false,unique = true)
    private String name;
    @Column
    private double total_price;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @OneToOne(optional = false,mappedBy = "product")
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",unique = true,nullable = false)

    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "checklist_id",unique = true,nullable = false)
    private CheckList_Customer checkList_customer;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Category_for_dogs> ctg_dog;



    public Long getId() {
        return id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public Product() {

    }

    public Product(Long id, String name, double total_price) {

        this.id = id;
        this.name = name;
        this.total_price = total_price;
    }

}