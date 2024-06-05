
package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Tarjeta;
import services.TarjetaService;

@Controller
@RequestMapping("/tarjetas")
public class TarjetasController extends AbstractController {

	@Autowired
	private TarjetaService tarjetaService;


	public TarjetasController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/listaTarjetas", method = RequestMethod.GET)
	public ModelAndView action1() {
		ModelAndView result;
		Collection<Tarjeta> tarjetas;

		tarjetas = this.tarjetaService.findAll();
		System.out.println("Número de tarjetas en el controlador: " + tarjetas.size());
		result = new ModelAndView("tarjetas/listaTarjetas");
		result.addObject("tarjetas", tarjetas);

		return result;
	}

}
