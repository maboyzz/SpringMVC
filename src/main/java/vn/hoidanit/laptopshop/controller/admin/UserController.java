package vn.hoidanit.laptopshop.controller.admin;

import org.springframework.web.multipart.MultipartFile;

import vn.hoidanit.laptopshop.domain.Role;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UploadService;
import vn.hoidanit.laptopshop.service.UserService;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;
    private final UploadService uploadService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, UploadService uploadService,
            PasswordEncoder passwordEncoder) {
        this.uploadService = uploadService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;

    }

    @RequestMapping("/")
    public String getHomePage(Model model) {

        List<User> aUsers = this.userService.getAllUserByEmail("nthuy311023@gmail.com");
        System.out.println(aUsers);

        model.addAttribute("huy", "test");
        model.addAttribute("huy1", "nguyen tran huy");

        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userService.getAllUser();
        model.addAttribute("user", users);
        return "admin/user/show";
    }

    @RequestMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/detail";
    }

    @GetMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @PostMapping(value = "/admin/user/create")
    public String createUserPage(Model model,
            @ModelAttribute("newUser") User huy,
            @RequestParam("huyFile") MultipartFile file) {
        String avatar = this.uploadService.HandleSaveUploadFile(file, "avatar");
        String hashPassword = this.passwordEncoder.encode(huy.getPassword());

        huy.setRole(this.userService.getRoleByName(huy.getRole().getName()));
        huy.setAvatar(avatar);
        huy.setPassword(hashPassword);

        this.userService.handleSaveUser(huy);
        return "redirect:/admin/user";
    }

    @RequestMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User currentUser = this.userService.getUserById(id);
        model.addAttribute("newUser", currentUser);
        return "admin/user/update";
    }

    @PostMapping("/admin/user/update")
    public String potUpdateUser(Model model, @ModelAttribute("newUser") User huy) {
        User currentUser = this.userService.getUserById(huy.getId());
        if (currentUser != null) {
            currentUser.setAddress(huy.getAddress());
            currentUser.setFullName(huy.getFullName());
            currentUser.setPhone(huy.getPhone());
            this.userService.handleSaveUser(currentUser);
        }
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        User user = new User();
        user.setId(id);
        model.addAttribute("newUser", user);
        return "admin/user/delete";
    }

    @PostMapping("/admin/user/delete")
    public String postDeleteUserPage(Model model, @ModelAttribute("newUser") User huy) {
        this.userService.deleteUserById(huy.getId());
        return "redirect:/admin/user";
    }

}
