
package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/academia")
public class AcademiaController extends AbstractController {

	public AcademiaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/listaAcademia")
	public ModelAndView action1() {
		ModelAndView result;

		result = new ModelAndView("academia/listaAcademia");

		return result;
	}
}
