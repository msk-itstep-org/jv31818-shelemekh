package org.itstep.msk.app.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dogs_goods")
public class Category_for_dogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_product",nullable = false)
    private String name_merchen;
    @Column(name = "quality",
    unique = true)
    private String special_quality;
    //Специально- качество каждой породы собаки
    @ManyToMany
            @JoinTable(name = "category_product",
           joinColumns = @JoinColumn(name = "dogs_goods_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id",referencedColumnName = "id")
            )
    List<Product> prod_list;

    public List<Product> getProd_list() {
        return prod_list;
    }

    public void setProd_list(List<Product> prod_list) {
        this.prod_list = prod_list;
    }

    public Long getId() {

        return id;
    }

    public String getName_merchen() {
        return name_merchen;
    }

    public void setName_merchen(String name_merchen) {
        this.name_merchen = name_merchen;
    }

    public String getSpecial_quality() {
        return special_quality;
    }

    public void setSpecial_quality(String special_quality) {
        this.special_quality = special_quality;
    }

    public Category_for_dogs() {

    }

    public Category_for_dogs(Long id, String name_merchen, String special_quality) {

        this.id = id;
        this.name_merchen = name_merchen;
        this.special_quality = special_quality;
    }
}
