package org.itstep.msk.app.service;

import javassist.NotFoundException;
import lombok.SneakyThrows;
import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceProduct {

    private final ProductRepository productRepository;

    @Autowired
    public ServiceProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @SneakyThrows
    public Optional<Product> findById(Integer id) {
        return Optional.ofNullable(productRepository.findById(id).orElseThrow(
                () -> new org.webjars.NotFoundException("not found such product")));
    }

    public List<Product> findAllProduct() {
        return productRepository.findAll()
                .stream()
                .filter(product -> product.getName() != null && product.getTotalPrice() > 0)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public Product updateProduct(Integer id) {
        Optional<Product> productOptional = Optional.of(new Product());
        if (!productOptional.isPresent()) {
            throw new NotFoundException("not such product " + productOptional);
        }
        Product product = new Product();
        product.setTotalPrice(product.getTotalPrice());
        product.setName(product.getName());
        return productRepository.save(product);
    }

    @SneakyThrows
    public void removeProdById(Integer id) {
        if (id == null) {
            throw new NoSuchFieldException("not such field" + id + "exist in database ");
        }
        productRepository.deleteById(id);
    }
}
