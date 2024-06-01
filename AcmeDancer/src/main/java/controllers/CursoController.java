
package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/curso")
public class CursoController extends AbstractController {

	public CursoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/listado")
	public ModelAndView action1() {
		ModelAndView result;

		result = new ModelAndView("curso/listado");

		return result;
	}
}