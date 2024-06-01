
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Tutorial;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {

	@Query("select a from Tutorial a where a.id = ?1")
	Tutorial findById(int Id);

	@Query("select b from Tutorial b where b.Titulo = ?1")
	Tutorial findByTitulo(String nombre);
}
