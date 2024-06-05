
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Alumno;
import repositories.AlumnoRepository;
import security.UserAccount;

@Service
@Transactional
public class AlumnoService {

	@Autowired
	private AlumnoRepository	alumnoRepository;

	@Autowired
	private UserAccountService	userService;


	public AlumnoService() {
		super();
	}

	public Collection<Alumno> findAll() {
		Collection<Alumno> result;

		result = this.alumnoRepository.findAll();
		Assert.notNull(result);

		return result;
	}

	public Alumno findOne(final int almId) {
		Assert.isTrue(almId != 0);

		Alumno result;

		result = this.alumnoRepository.findOne(almId);
		Assert.notNull(result);

		return result;
	}

	public Alumno save(final Alumno alm) {
		Assert.notNull(alm);

		Alumno result;

		result = this.alumnoRepository.save(alm);

		return result;
	}

	public void delete(final Alumno alm) {
		Assert.notNull(alm);
		Assert.isTrue(alm.getId() != 0);
		Assert.isTrue(this.alumnoRepository.exists(alm.getId()));

		this.alumnoRepository.delete(alm);
	}

	// Other business methods -------------------------------------------------

	public UserAccount findUserAccount(final Alumno alm) {
		Assert.notNull(alm);

		UserAccount result;

		result = this.userService.findByUsuario(alm);

		return result;
	}
}
