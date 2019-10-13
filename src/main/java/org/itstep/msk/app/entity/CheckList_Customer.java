package org.itstep.msk.app.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "checklist")
public class CheckList_Customer {
  //  private Integer log;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name = "manager",nullable = false)
    private String phone_manager;

    @Column(length = 1000,name ="address_customer",nullable = true)
    private String address_customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",unique = true,nullable = false,updatable = false)
    private Customer customer;


    public List<Product> getPr_list() {

        return pr_list;
    }

    public void setPr_list(List<Product> pr_list) {
        this.pr_list = pr_list;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "checklist")
    private List<Product> pr_list;



    public Long getId() {
        return id;
    }



    public String getPhone_manager() {
        return phone_manager;
    }

    public void setPhone_manager(String phone_manager) {
        this.phone_manager = phone_manager;
    }

    public String getAddress_customer() {
        return address_customer;
    }

    public void setAddress_customer(String address_customer) {
        this.address_customer = address_customer;
    }

    public CheckList_Customer() {

    }

    public CheckList_Customer(String phone_manager, String address_customer) {

        this.phone_manager = phone_manager;
        this.address_customer = address_customer;
    }
}
