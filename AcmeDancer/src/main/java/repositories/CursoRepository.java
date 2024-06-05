
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
	/*
	 * @Query("select a from Curso a where a.titulo = ?1")
	 * Curso findByName(String nombre);
	 *
	 * @Query("select c from Curso c where c.fecha_fin > ?1")
	 * Collection<Curso> findAllActive(Date currentMoment);
	 * 
	 * 
	 * @Query("select count(s) from Curso s")
	 * public long countAllCurso();
	 */
}
