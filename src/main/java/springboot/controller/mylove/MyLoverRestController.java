package springboot.controller.mylove;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import springboot.controller.AbstractController;

@RestController
public class MyLoverRestController extends AbstractController{

	@RequestMapping("/lovepage")
	public ModelAndView myLoverChartContent() {
		
		return new ModelAndView(this.render("loveU"));
	}
	
}
