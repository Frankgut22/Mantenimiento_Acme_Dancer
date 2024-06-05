
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Academia;
import repositories.AcademiaRepository;

@Service
@Transactional
public class AcademiaService {

	@Autowired
	private AcademiaRepository academiaRepository;


	public AcademiaService() {
		super();
	}

	public Collection<Academia> findAll() {
		final Collection<Academia> result = this.academiaRepository.findAll();
		System.out.println("Academias encontradas: " + result.size());
		return result;
	}

	public Academia findById(final int id) {
		return this.academiaRepository.findById(id);

	}
	public Academia buscaAcademiaIdUsuario(final int id) {
		return this.academiaRepository.buscaAcademiaIdUsuario(id);
	}
	public void save(final Academia aca) {
		this.academiaRepository.save(aca);
	}
}
