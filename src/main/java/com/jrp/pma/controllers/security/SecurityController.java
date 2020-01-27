package com.jrp.pma.controllers.security;

import com.jrp.pma.dao.UserAccountRepository;
import com.jrp.pma.entities.authentication.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SecurityController {
    @Autowired
    BCryptPasswordEncoder bCryptEncoder;

    @Autowired
    UserAccountRepository accountRepo;

    @GetMapping("/register")
    public String register(Model model){
        UserAccount userAccount = new UserAccount();
        model.addAttribute("userAccount", userAccount);
        return "security/register";
    }

    @PostMapping("register/save")
    public String saveUser(Model model, UserAccount user){
        user.setPassword(bCryptEncoder.encode(user.getPassword()));
        accountRepo.save(user);
        return "redirect:/";
    }

    @GetMapping(value = "/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        String errorMessge = null;
        if(error != null) {
            errorMessge = "Username or Password is incorrect !!";
        }
        if(logout != null) {
            errorMessge = "You have been successfully logged out !!";
        }
        model.addAttribute("errorMessge", errorMessge);
        return "main/login";
    }
    @GetMapping(value="/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }
}
