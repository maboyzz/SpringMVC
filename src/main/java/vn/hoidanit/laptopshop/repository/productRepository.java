package vn.hoidanit.laptopshop.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.hoidanit.laptopshop.domain.Product;
import java.util.List;

@Repository
public interface productRepository extends JpaRepository<Product, Long> {

    Product save(Product product);

    Product findOneById(long id);

    Void deleteById(long id);
}
