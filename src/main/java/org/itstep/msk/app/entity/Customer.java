    package org.itstep.msk.app.entity;


    import com.fasterxml.jackson.annotation.JsonIgnore;
    import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

    @Data
    @Entity
    @Table( name = "customer")
    public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(unique = true,nullable = false)
        private Integer id;

        @Column( name = "name", nullable = false)
        @NotBlank
        @Size(min = 2, max = 20 ,
                message = "A form with name should be between 2 to 10")
        private String name;


        @Column(name = "email",
                nullable = false)
      //  @Email(regexp = "^(.+)@(.+)$", message = "Incorrect email")
        @Size(max = 20)
        private String email;

        public Customer() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Customer)) return false;
            Customer customer = (Customer) o;
            return id.equals(customer.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Column(name = "phone")
        @Pattern(regexp = "^((\\+7|7|8)+([0-9]{10})$)",message = "Invalid phone number")
        @Size(max = 20,message = "the digits should be not more than 10")
        private String phoneNumber;

        @Column(name = "password",nullable = false)
        @NotNull
        private String password;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }


        @ManyToMany
        @JoinTable(name = "custom_roles",joinColumns = @JoinColumn(name = "customer_id"),inverseJoinColumns =
                    @JoinColumn(name ="roles_id" ))
        @JsonIgnore
        private Set<Role> role;


        public Set<Role> getRole() {
            return this.role;
        }

        public void setRole(final Set<Role> role) {
            this.role = role;
        }



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

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public Customer(String password,String name) {
            this.name = name;
          //  this.email = email;
            this.password = password;
        }
    }
