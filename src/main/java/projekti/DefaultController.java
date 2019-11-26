package projekti;

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

    @Autowired
    AccountService accountService;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/")
    public String helloWorld(Model model) {
        model.addAttribute("message", "World!");
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "registering";
    }

    @PostMapping("/register")
    public String postRegister(@RequestParam String name, @RequestParam String password, @RequestParam String merkkijono) {
        Account account = new Account();
        account.setMerkkijono(merkkijono);
        account.setPassword(encoder.encode(password));
        account.setName(name);
        account.getAuthorities().add("USER");

        accountService.addAccount(account);

        return "redirect:/";
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam String name, @RequestParam String password) {
        return "redirect:/";
    }

}
