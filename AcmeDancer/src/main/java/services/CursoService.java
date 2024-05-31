
package Services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
