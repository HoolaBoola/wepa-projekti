package projekti;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projekti.entities.Account;
import projekti.services.AccountService;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String helloWorld(Model model) {
        model.addAttribute("message", "World!");
        return "index";
    }

}
