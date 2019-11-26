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

    @Autowired
    AccountService accountService;

    @Autowired
    PasswordEncoder encoder;
    
    @Profile("test")
    public String index(Model model){
        System.out.println(accountService.list());
        return "index";
    }

    @GetMapping("/")
    public String helloWorld(Model model) {
        System.out.println("Getmapping toimii juuresta");
        model.addAttribute("message", "World!");
        return "index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        accountService.list().forEach(System.out::println);
        return "registering";
    }

    @PostMapping("/register")
    public String postRegister(@RequestParam String name, @RequestParam String password, @RequestParam String merkkijono, @RequestParam String username) {
        System.out.println("Postmapping toimii rekisteröinnissä");
        Account account = new Account();
        account.setUser(username);
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


}
