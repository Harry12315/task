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
public class Modify2 {

	@Autowired
	private User user;

	@GetMapping("/modify2")
	public ModelAndView modify2(ModelAndView model){
		model.setViewName("modify2");
		return model;
	}

	@PostMapping("/modify2")
	public String modify2(LoginRequestBean bean,HttpSession session) {
		String username = bean.getUsername();
		String password = bean.getPassword();
		String modify = (String) session.getAttribute("modify");

		try {
			user.update(username,password,modify);
			return "success";
		} catch (Exception e) {
			return "false";
		}
	}

}
