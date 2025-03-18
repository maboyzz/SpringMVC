package vn.hoidanit.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.Role;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.productRepository;
import vn.hoidanit.laptopshop.repository.roleRepository;

@Service
public class ProductService {

    private final roleRepository roleRepository;
    private final productRepository productRepository;

    public ProductService(vn.hoidanit.laptopshop.repository.roleRepository roleRepository,
            vn.hoidanit.laptopshop.repository.productRepository productRepository) {
        this.roleRepository = roleRepository;
        this.productRepository = productRepository;
    }

    public Product handleSaveProduct(Product product) {
        return this.productRepository.save(product);
    }

    public Role getRoleByName(String name) {
        return this.roleRepository.findByName(name);
    }

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    public Product findOneById(Long id) {
        return this.productRepository.findOneById(id);
    }

    public void deleteProductById(long id) {
        this.productRepository.deleteById(id);
    }

}
