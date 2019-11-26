package projekti;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    BCryptPasswordEncoder encoder;
    
    @Profile("test")
    public String index(Model model){
        System.out.println(accountService.list());
        return "index";
    }

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
        account.setAuthorities(new ArrayList<>());
        account.setFollowers(new ArrayList<>());
        account.setImages(new ArrayList<>());
        account.getAuthorities().add("USER");
        
        System.out.println("Account luotu");
        accountService.addAccount(account);

        return "redirect:/";
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam String name, @RequestParam String password) {
        return "redirect:/";
    }

}
