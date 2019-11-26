package org.itstep.msk.app.entity;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "dogs_goods")
public class categoryForDogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "name_product",nullable = false)
    private String nameMerchen;

    @Column(name = "quality" )
    private String specialQuality;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof categoryForDogs)) return false;
        categoryForDogs that = (categoryForDogs) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



    //Специально- качество каждой породы собаки
    @ManyToMany
    @JoinTable(name = "category_product", joinColumns = @JoinColumn(name = "dogs_goods_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id",referencedColumnName = "id")
            )
    List<Product> prodList;


    public List<Product> getProdList() {
        return prodList;
    }

    public void setProdList(List<Product> prodList) {
        this.prodList = prodList;
    }


    public Integer getId() {

        return id;
    }

    public String getNameMerchen() {
        return nameMerchen;
    }


    public void setNameMerchen(String nameMerchen) {
        this.nameMerchen = nameMerchen;
    }


    public String getSpecialQuality() {
        return specialQuality;
    }


    public void setSpecialQuality(String specialQuality) {
        this.specialQuality = specialQuality;
    }



}
