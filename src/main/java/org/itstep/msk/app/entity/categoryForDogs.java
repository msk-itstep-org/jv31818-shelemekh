package org.itstep.msk.app.entity;


import javax.persistence.*;
import java.util.List;

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
    private String special_quality;

    //Специально- качество каждой породы собаки
    @ManyToMany
    @JoinTable(name = "category_product", joinColumns = @JoinColumn(name = "dogs_goods_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id",referencedColumnName = "id")
            )
    List<Product> prod_list;


    public List<Product> getProd_list() {
        return prod_list;
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


    public String getSpecial_quality() {
        return special_quality;
    }


    public void setSpecial_quality(String special_quality) {
        this.special_quality = special_quality;
    }



}
