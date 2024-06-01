
package Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Tarjeta;
import repositories.TarjetaRepository;

@Service
@Transactional
public class TarjetaService {

	@Autowired
	private TarjetaRepository tarjetaRepository;


	public TarjetaService() {
		super();
	}

	public Tarjeta findOne(final int tarjetaId) {
		Assert.isTrue(tarjetaId != 0);

		Tarjeta result;

		result = this.tarjetaRepository.findOne(tarjetaId);
		Assert.notNull(result);

		return result;
	}

	public Tarjeta save(final Tarjeta tar) {
		Assert.notNull(tar);

		Tarjeta result;

		result = this.tarjetaRepository.save(tar);

		return result;
	}

	public void delete(final Tarjeta tar) {
		Assert.notNull(tar);
		Assert.isTrue(tar.getId() != 0);
		Assert.isTrue(this.tarjetaRepository.exists(tar.getId()));

		this.tarjetaRepository.delete(tar);
	}
}
