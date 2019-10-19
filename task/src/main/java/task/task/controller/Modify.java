package task.task.controller;

import javax.servlet.http.HttpSession;

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
public class Modify {

	@Autowired
	private User user;

	@GetMapping("/modify")
	public ModelAndView modify(ModelAndView model){
		model.setViewName("modify");
		return model;
	}

	@PostMapping("/modify")
	public String modify(LoginRequestBean bean,HttpSession session) {
		String username = bean.getUsername();
		String password = bean.getPassword();
		if(user.checkUser(username, password)==null) {
			return "false";
		}else {
		session.setAttribute("modify", username);
		return "success";
		}
	}

}
