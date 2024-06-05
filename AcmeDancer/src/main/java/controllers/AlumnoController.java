
package controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Alumno;
import domain.Tarjeta;
import security.Authority;
import security.Encriptado;
import security.UserAccount;
import services.AlumnoService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController extends AbstractController {

	@Autowired
	private AlumnoService	alumnoService;
	private Alumno			alumnoGlobal;
	private UserAccount		userAccount;


	public AlumnoController() {
		super();
		// TODO Auto-generated constructor stub
	}
	//////////////////////////Crear
	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public ModelAndView crear() {

		ModelAndView result;
		final Alumno alumno = new Alumno();
		result = new ModelAndView("alumno/crear");
		result.addObject("alumno", alumno);
		return result;
	}
	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("alumno") final Alumno alumno, final BindingResult binding) {
		ModelAndView result;

		try {
			if (binding.hasErrors())
				result = new ModelAndView("redirect:/security/login.do");
			else {

				this.alumnoGlobal = alumno;

				final List<Tarjeta> nombreTitular = null;
				final Tarjeta tarjeta = new Tarjeta();

				//				tarjeta.setAnio(2025);
				//				tarjeta.setCvv(065);
				//				tarjeta.setMes(02);
				//				tarjeta.setTipoTarjeta("visa");
				//				tarjeta.setNombreTitular("AlumnoTest");
				//				tarjeta.setNumeroTarjeta(789465321);
				//
				//				nombreTitular.add(tarjeta);

				//this.alumnoGlobal.setNombreTitular(nombreTitular);

				System.out.println("Controlador Alumno: " + this.alumnoGlobal);
				result = new ModelAndView("redirect:/alumno/crearAccount.do");//redirige al siguiente formulario
			}
		} catch (final Exception e) {
			result = new ModelAndView("redirect:/security/login.do");
			result.addObject("error", "Ocurrió un error al guardar el usuario. Por favor, inténtalo de nuevo.");
			e.printStackTrace(); // Asegúrate de loggear la excepción para obtener más detalles.
		}
		return result;
	}

	//////////////////////Crea User Account
	@RequestMapping(value = "/crearAccount", method = RequestMethod.GET)
	public ModelAndView crearAccount() {

		final UserAccount user = new UserAccount();

		ModelAndView result;

		result = new ModelAndView("alumno/crearAccount");
		result.addObject("user", user);
		return result;
	}
	@RequestMapping(value = "/crearAccount", method = RequestMethod.POST)
	public ModelAndView crearAccountsave(@ModelAttribute("user") final UserAccount user, final BindingResult binding) {
		ModelAndView result = new ModelAndView();
		System.out.println("Controlador Account " + user.getUsername());

		final Authority autoridad = new Authority();
		autoridad.setAuthority("ADMIN");/// Será admin hasta que se creeen los nuevos roles
		final Collection<Authority> autoridades = new ArrayList<>();
		autoridades.add(autoridad);
		user.setAuthorities(autoridades);

		this.userAccount = user;
		this.userAccount.setPassword(Encriptado.getMD5(user.getPassword()));

		this.alumnoGlobal.setUserAccount(this.userAccount);
		System.out.println("Controlador Alumno: " + this.alumnoGlobal);
		System.out.println("Controlador user Account: " + this.userAccount);

		this.alumnoService.save(this.alumnoGlobal);

		System.out.println("Controlador Variable global:  " + this.userAccount.getUsername());

		result = new ModelAndView("redirect:/security/login.do");

		return result;
	}

}
