
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Solicitud_curso;

@Repository
public interface SolicitudCursoRepository extends JpaRepository<Solicitud_curso, Integer> {

}
