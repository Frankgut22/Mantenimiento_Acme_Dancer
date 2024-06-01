
package Services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Academia;
import repositories.AcademiaRepository;
import security.UserAccount;

@Service
@Transactional
public class AcademiaService {

	@Autowired
	private AcademiaRepository	AcademiaRepository;

	@Autowired
	private UserAccountService	UsuarioService;


	public AcademiaService() {
		super();
	}

	public Collection<Academia> findAll() {
		Collection<Academia> result;

		result = this.AcademiaRepository.findAll();
		Assert.notNull(result);

		return result;
	}

	public Academia findOne(final int Id) {
		Assert.isTrue(Id != 0);

		Academia result;

		result = this.AcademiaRepository.findOne(Id);
		Assert.notNull(result);

		return result;
	}

	public Academia save(final Academia acad) {
		Assert.notNull(acad);

		Academia result;

		result = this.AcademiaRepository.save(acad);

		return result;
	}

	public void delete(final Academia acad) {
		Assert.notNull(acad);
		Assert.isTrue(acad.getId() != 0);
		Assert.isTrue(this.AcademiaRepository.exists(acad.getId()));

		this.AcademiaRepository.delete(acad);
	}

	public UserAccount findAcademiaAccount(final Academia acad) {
		Assert.notNull(acad);

		UserAccount result;

		result = this.UsuarioService.findByUsuario(acad);

		return result;
	}
}
