
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Administrador;
import repositories.AdministradorRepository;
import security.UserAccount;

@Service
@Transactional
public class AdministradorService {

	@Autowired
	private AdministradorRepository	adminRepository;

	@Autowired
	private UserAccountService		userService;


	public AdministradorService() {
		super();
	}

	public Collection<Administrador> findAll() {
		Collection<Administrador> result;

		result = this.adminRepository.findAll();
		Assert.notNull(result);

		return result;
	}

	public Administrador findOne(final int admId) {
		Assert.isTrue(admId != 0);

		Administrador result;

		result = this.adminRepository.findOne(admId);
		Assert.notNull(result);

		return result;
	}

	public Administrador save(final Administrador adm) {
		Assert.notNull(adm);

		Administrador result;

		result = this.adminRepository.save(adm);

		return result;
	}

	public void delete(final Administrador adm) {
		Assert.notNull(adm);
		Assert.isTrue(adm.getId() != 0);
		Assert.isTrue(this.adminRepository.exists(adm.getId()));

		this.adminRepository.delete(adm);
	}

	// Other business methods -------------------------------------------------

	public UserAccount findUserAccount(final Administrador adm) {
		Assert.notNull(adm);

		UserAccount result;

		result = this.userService.findByUsuario(adm);

		return result;
	}
}
