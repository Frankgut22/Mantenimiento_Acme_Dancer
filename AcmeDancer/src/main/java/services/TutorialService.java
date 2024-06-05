
package services;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Tutorial;
import repositories.TutorialRepository;

@Service
@Transactional
public class TutorialService {

	@Autowired
	private TutorialRepository tutorialRepository;


	public Collection<Tutorial> findAll() {

		final Collection<Tutorial> result = this.tutorialRepository.findAll();
		System.out.println("Tutoriales encontrados: " + result.size());
		return result;
	}
	public void save(final Tutorial tutorial) {
		this.tutorialRepository.save(tutorial);
	}

	public Tutorial findById(final int id) {
		final Optional<Tutorial> tutorialOptional = this.tutorialRepository.findById(id);
		if (tutorialOptional.isPresent())
			return tutorialOptional.get();
		else
			// Manejar caso en que no se encuentra el tutorial
			return null;

	}
	public void update(final Tutorial tutorial) {
		// Verifica si el tutorial existe
		if (this.findById(tutorial.getId()) != null)
			this.tutorialRepository.save(tutorial);
		else {
			// Manejar caso en que el tutorial no existe
			// Puedes lanzar una excepción o manejarlo de otra manera apropiada
		}
	}
	public void deleteById(final int id) {
		this.tutorialRepository.delete(id);
	}
}
