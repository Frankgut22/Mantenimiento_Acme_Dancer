
package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Curso;
import security.LoginService;
import security.UserAccount;
import services.AcademiaService;
import services.CursoService;

@Controller
@RequestMapping("/curso")
public class CursoController extends AbstractController {

	@Autowired
	private CursoService	cursoService;
	@Autowired
	private AcademiaService	academiaService;


	public CursoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	//------------------MOSTRAR---------------------------
	@RequestMapping(value = "/listado", method = RequestMethod.GET)
	public ModelAndView action1() {
		ModelAndView result;
		final Collection<Curso> cursos = this.cursoService.findAll();
		System.out.println("Número de cursos en el controlador: " + cursos.size());
		result = new ModelAndView("curso/listado");
		result.addObject("cursos", cursos);

		return result;
	}

	//------------------ELMINAR--------------------------------
	@RequestMapping(value = "/listado", method = RequestMethod.POST)
	public String delete(@RequestParam("id") final int id) {
		this.cursoService.deleteById(id);
		return "redirect:/curso/listado.do";
	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public ModelAndView editar(@RequestParam final int id) {
		ModelAndView result;
		final Curso curso = this.cursoService.findById(id);
		result = new ModelAndView("curso/editar");
		result.addObject("curso", curso);
		return result;
	}

	@RequestMapping(value = "/editar", method = RequestMethod.POST, params = "save")
	public ModelAndView guardar(@Valid final Curso curso, final BindingResult binding) {
		ModelAndView result;
		if (binding.hasErrors())
			result = new ModelAndView("curso/editar");
		else {
			this.cursoService.save(curso);
			result = new ModelAndView("redirect:/curso/listado.do");
		}
		return result;
	}

	//------------------Crear---------------------------
	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public ModelAndView create() {
		final ModelAndView result;
		final Curso curso = new Curso();
		result = new ModelAndView("curso/crear");
		result.addObject("curso", curso);
		return result;
	}
	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("curso") final Curso curso, final BindingResult binding) {
		ModelAndView result = null;
		final UserAccount user = LoginService.getPrincipal();

		System.out.println("Controlador 2 de crear curso " + curso);
		try {
			if (binding.hasErrors())
				result = new ModelAndView("curso/crear");
			else {

				curso.setNombreComercial(this.academiaService.findById(user.getId()));
				this.cursoService.save(curso);
				result = new ModelAndView("redirect:/curso/listado.do");
			}
		} catch (final Exception e) {
			result = new ModelAndView("curso/curso");
			result.addObject("error", "Ocurrió un error al guardar el curso. Por favor, inténtalo de nuevo.");
			e.printStackTrace(); // Asegúrate de loggear la excepción para obtener más detalles.
		}
		return result;
	}
}
