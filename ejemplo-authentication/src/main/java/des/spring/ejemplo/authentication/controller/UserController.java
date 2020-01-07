package des.spring.ejemplo.authentication.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import des.spring.ejemplo.authentication.entity.User;
import des.spring.ejemplo.authentication.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/list")
	public String listUsers(Model theModel) {
		List<User> lUsers  = userService.getUsers();
		
		theModel.addAttribute("users", lUsers);
		return "list-users";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable ("id") long id, Model model)  {
		userService.deleteUser(id);
		return "redirect:/user/list";
	}
	
	@GetMapping("/update/{id}")
	public String showFormForUpdate(@PathVariable("id") long id,
									Model theModel) {
		User user = userService.getUser(id);
		theModel.addAttribute("user", user);
		return "update-user";
	}
	
	
	@PostMapping("update/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
		user.setIdUsuario(id);
		userService.saveUser(user);		

		return "redirect:/user/list";
	}
	
	@GetMapping("/myprofile")
	public String myprofile(Model theModel) {

		return "myprofile";
	}
}
