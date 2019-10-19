package task.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import task.task.model.LoginRequestBean;
import task.task.service.User;

@RestController
@RequestMapping("/")
public class Login {

	@Autowired
	private User user;

	@GetMapping("/login")
	public ModelAndView login(ModelAndView model){
		model.setViewName("login");
		return model;
	}

	@PostMapping("/login")
	public String login(LoginRequestBean bean) {
		String username = bean.getUsername();
		String password = bean.getPassword();
		if(user.checkUser(username, password)==null) {
			return "false";
		}else {
		return "success";
		}
	}

}
