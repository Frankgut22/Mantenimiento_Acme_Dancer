
package services;

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
		final Collection<Curso> result = this.CursoRepository.findAll();
		System.out.println("Cursos encontrados: " + result.size());
		return result;
	}

	public void deleteById(final int id) {
		this.CursoRepository.delete(id);
	}

	public Curso findById(final int id) {
		return this.CursoRepository.findOne(id);
	}

	public Curso save(final Curso curso) {
		return this.CursoRepository.save(curso);
	}

}
