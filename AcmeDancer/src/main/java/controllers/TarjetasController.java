
package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tarjetas")
public class TarjetasController extends AbstractController {

	public TarjetasController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/listaTarjetas")
	public ModelAndView action1() {
		ModelAndView result;

		result = new ModelAndView("tarjetas/listaTarjetas");

		return result;
	}

}
