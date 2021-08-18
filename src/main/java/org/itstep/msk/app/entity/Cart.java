package org.itstep.msk.app.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(targetEntity = Product.class, cascade= CascadeType.ALL)
    @Column(nullable = true,table = "prod_list")
    private List<Product> productList;
}
