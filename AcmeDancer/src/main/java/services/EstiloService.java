
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Estilo;
import repositories.EstiloRepository;

@Service
@Transactional
public class EstiloService {

	@Autowired
	private EstiloRepository estiloRepository;

	// Supporting services ----------------------------------------------------


	// Constructors -----------------------------------------------------------

	public EstiloService() {
		super();
	}
	// Simple CRUD methods ----------------------------------------------------

	public Collection<Estilo> findAll() {
		Collection<Estilo> result;

		result = this.estiloRepository.findAll();

		return result;
	}

	public Estilo findOne(final int estiloId) {
		Assert.isTrue(estiloId != 0);

		Estilo result;

		result = this.estiloRepository.findOne(estiloId);
		Assert.notNull(result);

		return result;
	}

	public Estilo save(final Estilo est) {
		Assert.notNull(est);

		Estilo result;

		result = this.estiloRepository.save(est);

		return result;
	}

	public void delete(final Estilo est) {
		Assert.notNull(est);
		Assert.isTrue(est.getId() != 0);
		Assert.isTrue(this.estiloRepository.exists(est.getId()));

		this.estiloRepository.delete(est);
	}
}
