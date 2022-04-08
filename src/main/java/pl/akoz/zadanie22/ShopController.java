package pl.akoz.zadanie22;

import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShopController {

    private MessageService messageService;

    public ShopController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/products")
    public String products() {
        return "products";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("message", new Message());
        return "form";
    }

    @PostMapping("/send")
    public String send(Message message) {
        messageService.createMessage(message);
        messageService.createReply(message);
        return "redirect:/";

    }

}


