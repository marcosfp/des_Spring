package des.spring.ejemplo.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import des.spring.ejemplo.authentication.entity.User;
import des.spring.ejemplo.authentication.service.UserService;

@Controller
public class IndexController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/index")
	public String index() {

		return "index";
	}
	
    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
       

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }
    
    
	@PostMapping("/createUser")
	public String createUser(@ModelAttribute("customer") User theUser) {
		User user= userService.saveUser(theUser);

		return "redirect:/user/list";
	}
	
	@GetMapping("/signup")
	public String showForm(Model theModel) {
		User user=new User();
		theModel.addAttribute("user", user);
		return "signup";
	}
	
	
	
}
