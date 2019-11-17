package projekti;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultController {

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
    public String postRegister(@RequestParam String name, @RequestParam String password, @RequestParam String merkkijono){
        return "redirect:/";
    }
    
    @PostMapping("/login")
    public String postLogin(@RequestParam String name, @RequestParam String password){
        return "redirect:/";
    }

}
