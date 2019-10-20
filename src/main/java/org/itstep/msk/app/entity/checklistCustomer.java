package org.itstep.msk.app.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "checklist")
public class checklistCustomer {
  //  private Integer log;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id ;

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

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",nullable = false,updatable = false)
    private Customer customer;



  //  @OneToMany(fetch = FetchType.LAZY, mappedBy = "checklist")
  //  private List<Product> pr_list;



    public Integer getId() {
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


}
