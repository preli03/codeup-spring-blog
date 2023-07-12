package mireles.codeupspringblog.controllers;

import mireles.codeupspringblog.models.User;
import mireles.codeupspringblog.services.Authorization;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class AuthenticationController {
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        User loggedInUser = Authorization.getLoggedInUser();
        model.addAttribute("loggedInUser", loggedInUser);

        return "users/login";
    }
}
