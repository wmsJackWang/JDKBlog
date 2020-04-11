package springboot.controller.mylove;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import springboot.controller.AbstractController;

@Controller
public class MyLoverController extends AbstractController{

//	@GetMapping(value="/mylove")
	public String myLoverChartContent() {
		
		System.out.println("into.... loveSystem");
		return this.render("loveU");
	}
}
