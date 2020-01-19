package com.jrp.pma.security;

import com.jrp.pma.dao.UserAccountRepository;
import com.jrp.pma.entities.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
}
