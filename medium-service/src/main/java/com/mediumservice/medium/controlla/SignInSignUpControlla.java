package com.mediumservice.medium.controlla;

import com.mediumservice.medium.models.SignUpData;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SignInSignUpControlla {
    
    @GetMapping(value = "/signup")
    public String showSignUpPage(Model model) {
        SignUpData signUpData = new SignUpData();
        model.addAttribute("signUpData", signUpData);
        return "signUpPage";
    }

    @PostMapping(value = "/signup")
    @ResponseBody
    public String saveAndValidateSignUpData(Model model, @ModelAttribute("signUpData")SignUpData signUpData) {
        
        return "Success ... But nothing implemented yet and so nothing happened!";
    }


}
