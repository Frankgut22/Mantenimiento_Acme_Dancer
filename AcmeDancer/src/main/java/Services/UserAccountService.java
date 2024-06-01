
package Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Usuario;
import security.UserAccount;
import security.UserAccountRepository;

@Service
@Transactional
public class UserAccountService {

	// Managed repository -----------------------------------------------------

	@Autowired
	private UserAccountRepository userAccountRepository;

	// Supporting services ----------------------------------------------------


	// Constructors -----------------------------------------------------------

	public UserAccountService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public UserAccount findByUsuario(final Usuario user) {
		Assert.notNull(user);

		UserAccount result;

		result = this.userAccountRepository.findByUsuarioId(user.getId());

		return result;
	}

	// Other business methods -------------------------------------------------

}
