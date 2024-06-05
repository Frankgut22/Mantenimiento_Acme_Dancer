
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Solicitud_curso;
import repositories.SolicitudCursoRepository;

@Service
@Transactional
public class SolicitudCursoService {

	@Autowired
	private SolicitudCursoRepository solicitudRepository;


	public Collection<Solicitud_curso> findAll() {
		Collection<Solicitud_curso> result;

		result = this.solicitudRepository.findAll();

		return result;
	}

	public Solicitud_curso findOne(final int soliId) {
		Assert.isTrue(soliId != 0);

		Solicitud_curso result;

		result = this.solicitudRepository.findOne(soliId);
		Assert.notNull(result);

		return result;
	}

	public Solicitud_curso save(final Solicitud_curso soli) {
		Assert.notNull(soli);

		Solicitud_curso result;

		result = this.solicitudRepository.save(soli);

		return result;
	}

	public void delete(final Solicitud_curso soli) {
		Assert.notNull(soli);
		Assert.isTrue(soli.getId() != 0);
		Assert.isTrue(this.solicitudRepository.exists(soli.getId()));

		this.solicitudRepository.delete(soli);
	}
}
