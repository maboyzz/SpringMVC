package vn.hoidanit.laptopshop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {

    @GetMapping("/")

    public String index() {

        return "Hello World NT Huy66";

    }

    @GetMapping("/user")

    public String userPage() {
        return "chỉ có người dùng truy cập";
    }

    @GetMapping("/admin")

    public String adminPage() {
        return "chỉ có admin truy cập";
    }

}
