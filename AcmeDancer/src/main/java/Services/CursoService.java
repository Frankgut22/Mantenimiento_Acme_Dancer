
package Services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Curso;
import repositories.CursoRepository;

@Service
@Transactional
public class CursoService {

	@Autowired
	private CursoRepository CursoRepository;

	// Supporting services ----------------------------------------------------


	// Constructors -----------------------------------------------------------

	public CursoService() {
		super();
	}
	// Simple CRUD methods ----------------------------------------------------

	public Collection<Curso> findAll() {
		Collection<Curso> result;

		result = this.CursoRepository.findAll();

		return result;
	}

	public Curso findOne(final int cursoId) {
		Assert.isTrue(cursoId != 0);

		Curso result;

		result = this.CursoRepository.findOne(cursoId);
		Assert.notNull(result);

		return result;
	}

	public Curso save(final Curso cur) {
		Assert.notNull(cur);

		Curso result;

		result = this.CursoRepository.save(cur);

		return result;
	}

	public void delete(final Curso cur) {
		Assert.notNull(cur);
		Assert.isTrue(cur.getId() != 0);
		Assert.isTrue(this.CursoRepository.exists(cur.getId()));

		this.CursoRepository.delete(cur);
	}
}
