package org.itstep.msk.app.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "checklist")
public class checklistCustomer {
  //  private Integer log;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id ;

    @Column(name = "manager",nullable = false)
    private String phoneManager;

    @Column(length = 1000,name ="addressCustomer",nullable = true)
    private String addressCustomer;



    public Integer getId() {
        return id;
    }



    public String getPhoneManager() {
        return phoneManager;
    }

    public void setPhoneManager(String phoneManager) {
        this.phoneManager = phoneManager;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof checklistCustomer)) return false;
        checklistCustomer that = (checklistCustomer) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
