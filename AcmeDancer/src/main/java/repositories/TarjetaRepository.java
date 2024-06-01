
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Tarjeta;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer> {

	@Query("select t from Tarjeta t where t.nombreTitular = ?1")
	Tarjeta findByTitular(String nombre);
}
