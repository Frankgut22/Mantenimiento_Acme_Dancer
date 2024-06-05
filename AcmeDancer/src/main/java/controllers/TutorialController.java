
package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Academia;
import domain.Tutorial;
import security.UserAccount;
import services.AcademiaService;
import services.TutorialService;
import services.UserAccountService;

@Controller
@RequestMapping("/tutorial")
public class TutorialController extends AbstractController {

	@Autowired
	private TutorialService		tutorialService;
	@Autowired
	private AcademiaService		academiaService;

	@Autowired
	private UserAccountService	useraccountService;


	public TutorialController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/listaTuto", method = RequestMethod.GET)
	public ModelAndView action1() {
		ModelAndView result;
		Collection<Tutorial> tutoriales;

		tutoriales = this.tutorialService.findAll();
		System.out.println("Número de tutoriales en el controlador: " + tutoriales.size());
		result = new ModelAndView("tutorial/listaTuto");
		result.addObject("tutoriales", tutoriales);

		return result;
	}
	@RequestMapping(value = "/nuevoTutorial", method = RequestMethod.GET)
	public ModelAndView create() {

		ModelAndView result;
		final Tutorial tutorial = new Tutorial();
		result = new ModelAndView("tutorial/nuevoTutorial");
		result.addObject("tutorial", tutorial);
		return result;
	}

	@RequestMapping(value = "/listaTuto", method = RequestMethod.POST)
	public String delete(@RequestParam("id") final int id) {
		this.tutorialService.deleteById(id);
		return "redirect:/tutorial/listaTuto.do";
	}

	@RequestMapping(value = "/nuevoTutorial", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("tutorial") final Tutorial tutorial, final BindingResult binding) {
		ModelAndView result;
		int id = 0;
		try {
			final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			final UserAccount user = (UserAccount) authentication.getPrincipal();

			//	final Academia aca = this.academiaService.findByIdUsuario(user.getId());

			System.out.println("\n\nMuestra Id user " + user + "   " + user.getUsername());

			final Academia aca = this.academiaService.buscaAcademiaIdUsuario(user.getId());
			id = aca.getId();
			System.out.println("\n\nMuestra Academia " + user + "   " + aca);
		} catch (final Exception e) {
			System.out.println("Se produjo un error al obtener el UserAccount: " + e.getMessage());
		}

		try {
			if (binding.hasErrors())
				result = new ModelAndView("tutorial/nuevoTutorial");
			else {
				try {
					//final UserAccount user = LoginService.getPrincipal();
					//System.out.println("\n\n----------Id user " + user.getId());
				} catch (final Exception e) {
					System.out.println("Se produjo un error al obtener el UserAccount: " + e.getMessage());
				}
				tutorial.setNombreComercial(this.academiaService.findById(id));
				this.tutorialService.save(tutorial);
				result = new ModelAndView("redirect:/tutorial/listaTuto.do");
			}
		} catch (final Exception e) {
			result = new ModelAndView("tutorial/nuevoTutorial");
			result.addObject("error", "Ocurrió un error al guardar el tutorial. Por favor, inténtalo de nuevo.");
			e.printStackTrace(); // Asegúrate de loggear la excepción para obtener más detalles.
		}
		return result;
	}

	@RequestMapping(value = "/editarTutorial/{id}", method = RequestMethod.GET)
	public ModelAndView editar(@PathVariable("id") final int id) {
		ModelAndView result;
		final Tutorial tutorial = this.tutorialService.findById(id);
		result = new ModelAndView("tutorial/editarTutorial");
		result.addObject("tutorial", tutorial);
		return result;
	}
	@RequestMapping(value = "/editarTutorial", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("tutorial") final Tutorial tutorial, final BindingResult binding) {
		ModelAndView result;
		if (binding.hasErrors())
			result = new ModelAndView("tutorial/editarTutorial");
		else {
			this.tutorialService.update(tutorial);
			result = new ModelAndView("redirect:/tutorial/listaTuto.do");
		}
		return result;
	}
}
