package hello.hellospring.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by jeaha on 11/18/23
 */
@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
