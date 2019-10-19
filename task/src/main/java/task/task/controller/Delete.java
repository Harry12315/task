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
public class Delete {

	@Autowired
	User user;

	@GetMapping("/delete")
	public ModelAndView delete(ModelAndView model){
		model.setViewName("delete");
		return model;
	}

	@PostMapping("/delete")
	public String delete(LoginRequestBean bean){
		String username = bean.getUsername();
		String password = bean.getPassword();

		if(user.checkUser(username, password)==null) {
			return "false";
		}

		try {
			user.delete(username,password);
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}
}
