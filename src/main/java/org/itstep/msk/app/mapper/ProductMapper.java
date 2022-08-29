package org.itstep.msk.app.mapper;

import lombok.RequiredArgsConstructor;
import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.entity.model.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private static ModelMapper mapper;

    public static Product fromDTO(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getNameProduct());
        product.setTotalPrice(productDTO.getTotalPrice());
        product.setCustomer(productDTO.getCustomers());
        return mapper.map(productDTO, Product.class);
    }

    public static ProductDTO fromEntity(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setNameProduct(product.getName());
        productDTO.setTotalPrice(product.getTotalPrice());
        productDTO.setCustomers(product.getCustomer());
        return mapper.map(product,ProductDTO.class);
    }
}
