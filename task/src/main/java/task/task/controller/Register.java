package task.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import task.task.model.LoginRequestBean;
import task.task.model.Users;
import task.task.service.User;

@RestController
@RequestMapping("/")
public class Register {

	@Autowired
	private User user;

	@GetMapping("/preregister")
	public ModelAndView preregister(ModelAndView model){
		model.setViewName("preregister");
		return model;
	}

	@GetMapping("/register")
	public ModelAndView register(ModelAndView model){
		model.setViewName("register");
		return model;
	}

	@PostMapping("/register")
	public String register(LoginRequestBean bean) {
		String username = bean.getUsername();
		String password = bean.getPassword();
		Users users = new Users();
		users = user.checkName(username);
		if(!(users == null)) {
			return "false";
		}
		try {
			user.insert(username, password);
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

}
