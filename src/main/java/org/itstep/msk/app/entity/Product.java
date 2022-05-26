package org.itstep.msk.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(name = "name_product", unique = true)
    @ApiModelProperty(value = "This is name of product ",required = true)
    private String name;

    @Column(name = "final_price")
    @ApiModelProperty(value = "This is final cost of product",required = true)
    private double totalPrice;


    @OneToMany(targetEntity = Customer.class)
    @JoinColumn(name = "id", insertable = false,
            updatable = true, referencedColumnName = "id", nullable = true)
    @JsonIgnore
    private Set<Customer> customer;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.totalPrice, totalPrice) == 0 &&
                id.equals(product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(customer, product.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public Product() {
    }


    public Set<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Set<Customer> customer) {
        this.customer = customer;
    }


    public String getId() {
        return String.valueOf(id);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalPrice=" + totalPrice +
                ", customer=" + customer +
                '}';
    }
}