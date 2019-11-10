package org.itstep.msk.app.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table( name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles",cascade = CascadeType.ALL)
    private Set<Customer> custom ;

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", custom=" + custom +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Roles)) return false;
        final Roles roles = (Roles) o;
        return Objects.equals(this.id, roles.id) &&
                Objects.equals(this.name, roles.name) &&
                Objects.equals(this.custom, roles.custom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.custom);
    }

    public Roles() {
    }

    public Integer getId() {
        return this.id;
    }


    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Set<Customer> getCustom() {
        return this.custom;
    }

    public void setCustom(final Set<Customer> custom) {
        this.custom = custom;
    }
}
