package task.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import task.task.model.Users;
import task.task.service.User;

@RestController
@RequestMapping("/")
public class Show {

	@Autowired
	private User user;

	@GetMapping("/show")
	public ModelAndView show(ModelAndView model){
		List<Users> list = user.getUsers();
		model.addObject("users",list);
		model.setViewName("show");
		return model;
	}

}
