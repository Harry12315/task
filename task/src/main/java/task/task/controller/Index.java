package task.task.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class Index {

	@GetMapping("/index")
	public ModelAndView index(ModelAndView model){
		model.setViewName("index");
		return model;
	}

}
