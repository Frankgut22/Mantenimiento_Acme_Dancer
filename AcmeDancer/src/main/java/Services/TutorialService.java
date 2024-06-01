
package Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Tutorial;
import repositories.TutorialRepository;

@Service
@Transactional
public class TutorialService {

	@Autowired
	private TutorialRepository tutorialRepository;


	public TutorialService() {
		super();
	}

	public Tutorial findOne(final int tutoId) {
		Assert.isTrue(tutoId != 0);

		Tutorial result;

		result = this.tutorialRepository.findOne(tutoId);
		Assert.notNull(result);

		return result;
	}

	public Tutorial save(final Tutorial tuto) {
		Assert.notNull(tuto);

		Tutorial result;

		result = this.tutorialRepository.save(tuto);

		return result;
	}

	public void delete(final Tutorial tuto) {
		Assert.notNull(tuto);
		Assert.isTrue(tuto.getId() != 0);
		Assert.isTrue(this.tutorialRepository.exists(tuto.getId()));

		this.tutorialRepository.delete(tuto);
	}
}
