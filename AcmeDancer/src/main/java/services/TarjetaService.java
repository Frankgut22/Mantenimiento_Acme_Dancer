
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Tarjeta;
import repositories.TarjetaRepository;

@Service
@Transactional
public class TarjetaService {

	@Autowired
	private TarjetaRepository tarjetaRepository;


	public Collection<Tarjeta> findAll() {

		final Collection<Tarjeta> result = this.tarjetaRepository.findAll();
		System.out.println("Tutoriales encontrados: " + result.size());
		return result;
	}
}
