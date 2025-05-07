package vn.hoidanit.laptopshop.controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ItemsController {

    private ProductService productService;

    public ItemsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public String getDetailsPage(Model model, @PathVariable Long id) {
        List<Product> products = this.productService.getAllProducts();
        Product product = this.productService.findOneById(id);
        model.addAttribute("product", product);
        model.addAttribute("products", products);

        return "client/product/detail";
    }

    @PostMapping("/add-product-to-cart/{id}")
    public String testPost(@PathVariable long id, HttpServletRequest request) {
        long productID = id;
        HttpSession session = request.getSession(false);

        String email = (String) session.getAttribute("email");

        this.productService.handleAddProductToCart(email, productID, session);
        return "redirect:/";
    }
}
