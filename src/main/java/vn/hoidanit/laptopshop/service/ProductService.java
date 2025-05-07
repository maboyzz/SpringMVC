package vn.hoidanit.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import vn.hoidanit.laptopshop.domain.Cart;
import vn.hoidanit.laptopshop.domain.CartDetail;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.Role;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.CartDetailRepository;
import vn.hoidanit.laptopshop.repository.CartRepository;
import vn.hoidanit.laptopshop.repository.productRepository;
import vn.hoidanit.laptopshop.repository.roleRepository;

@Service
public class ProductService {

    private final roleRepository roleRepository;
    private final productRepository productRepository;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;
    private final UserService userService;

    public ProductService(vn.hoidanit.laptopshop.repository.roleRepository roleRepository,
            vn.hoidanit.laptopshop.repository.productRepository productRepository, CartRepository cartRepository,
            CartDetailRepository cartDetailRepository, UserService userService) {
        this.roleRepository = roleRepository;
        this.productRepository = productRepository;
        this.cartDetailRepository = cartDetailRepository;
        this.cartRepository = cartRepository;
        this.userService = userService;
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

    public Cart findCartByUser(User user) {
        return this.cartRepository.findByUser(user);

    }

    public void handleAddProductToCart(String email, long productID, HttpSession session) {

        User user = this.userService.findUserByEmail(email);
        if (user != null) {
            Cart cart = this.cartRepository.findByUser(user);
            if (cart == null) {
                Cart otherCard = new Cart();
                otherCard.setUser(user);
                otherCard.setSum(0);
                cart = cartRepository.save(otherCard);
            }
            Optional<Product> product = this.productRepository.findById(productID);
            if (product.isPresent()) {
                Product realProduct = product.get();
                // check san pham da co chua

                CartDetail oldDetail = this.cartDetailRepository.findByCartAndProduct(cart, realProduct);

                if (oldDetail == null) {
                    CartDetail cartDetail = new CartDetail();
                    cartDetail.setCart(cart);
                    cartDetail.setProduct(realProduct);
                    cartDetail.setPrice(realProduct.getPrice());
                    cartDetail.setQuantity(1);

                    this.cartDetailRepository.save(cartDetail);
                    // update cart sum
                    int s = cart.getSum() + 1;
                    cart.setSum(s);
                    this.cartRepository.save(cart);
                    session.setAttribute("sum", s);
                } else {
                    oldDetail.setQuantity(oldDetail.getQuantity() + 1);
                    this.cartDetailRepository.save(oldDetail);
                }

            }

        }
    }

}
