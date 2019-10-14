package org.itstep.msk.app.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table( name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column( name = "name", nullable = false)
    @NotNull
    @Size(min = 2, max = 10 ,
            message = "A form with name should be between 2 to 10")
    private String name;


    @Column(name = "user_email",
            nullable = false)
    @NotEmpty(message = "A form of email should not be empty")
    @Email(regexp = "^(.+)@(.+)$", message = "Incorrect email")
    private String email;

    @Column(name = "phone_number")
    @Pattern(regexp = "^((\\+7|7|8)+([0-9]){10})$",message = "Invalid phone number")
    @Size(max = 10,message = "the digits should be not more than 10")
    private String phone_number;


    @OneToOne(optional = false)
    @JoinColumn(name = "product_id",nullable = false,updatable = false)
    private Product product;


    public List<checklistCustomer> getCh_list() {
        return ch_list;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "checklist")
    private List<checklistCustomer> ch_list;

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }


}
