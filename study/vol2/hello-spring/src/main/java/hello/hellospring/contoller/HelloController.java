package hello.hellospring.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jeaha on 11/18/23
 */
@Controller
public class HelloController {
    
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "hell");
        
        return "/hello";
    }
    
    @GetMapping("/hell-mvc")
    public String hellMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "/hello";
    }
    
    @GetMapping("/hell-string")
    @ResponseBody
    public String hellString(@RequestParam(value = "name", required = false) String name) {
        return "hell the " + name;
    }
    
    static class Hello {
        private String name;
        
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
    }
    
    @GetMapping("/hell-api")
    @ResponseBody
    public Hello hellApi(@RequestParam("name") String name) {
        Hello hell = new Hello();
        hell.setName(name);
        
        return hell;
    }
}
