
package controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Academia;
import security.Authority;
import security.UserAccount;
import services.AcademiaService;

@Controller
@RequestMapping("/academia")
public class AcademiaController extends AbstractController {

	@Autowired
	private AcademiaService academiaService;


	public AcademiaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/listaAcademia", method = RequestMethod.GET)
	public ModelAndView action1() {
		ModelAndView result;
		final Collection<Academia> academias = this.academiaService.findAll();
		System.out.println("Número de Academias en el controlador: " + academias.size());
		result = new ModelAndView("academia/listaAcademia");
		result.addObject("academia", academias);

		return result;
	}

	///////////////////////////Crear
	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public ModelAndView crear() {

		ModelAndView result;
		final Academia academia = new Academia();
		result = new ModelAndView("academia/crear");
		result.addObject("academia", academia);
		return result;
	}
	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("academia") final Academia academia, final BindingResult binding) {
		ModelAndView result;
		final UserAccount user = new UserAccount();
		user.setPassword("contraseña");
		user.setUsername("TestetoAcademy");
		final Authority autoridad = new Authority();
		autoridad.setAuthority("ADMIN");
		final Collection<Authority> autoridades = new ArrayList<>();
		autoridades.add(autoridad);
		user.setAuthorities(autoridades);

		academia.setUserAccount(user);

		//academia.setUserAccount(userAccount);

		System.out.println("Controlador recive academia " + academia);

		try {
			if (binding.hasErrors())
				result = new ModelAndView("curso/crear");
			else {

				//academia.setNombreComercial(this.academiaService.findById(user.getId()));
				this.academiaService.save(academia);
				result = new ModelAndView("redirect:/security/login.do");
			}
		} catch (final Exception e) {
			result = new ModelAndView("redirect:/security/login.do");
			result.addObject("error", "Ocurrió un error al guardar el curso. Por favor, inténtalo de nuevo.");
			e.printStackTrace(); // Asegúrate de loggear la excepción para obtener más detalles.
		}
		return result;
	}

	//////////////////////Crea User Account
	@RequestMapping(value = "/crearAccount", method = RequestMethod.GET)
	public ModelAndView crearAccount() {

		ModelAndView result;
		final Academia academia = new Academia();
		result = new ModelAndView("academia/crearAccount");
		result.addObject("academia", academia);
		return result;
	}
}
