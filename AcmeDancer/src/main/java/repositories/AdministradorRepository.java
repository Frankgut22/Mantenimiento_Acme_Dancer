
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {

	/*
	 * @Query("select a from Announcement a where a.moment > ?1")
	 * Collection<Announcement> findAllActive(Date currentMoment);
	 * 
	 * @Query("select r.announcement from Registration r where r.owner.id = ?1")
	 * Collection<Announcement> findByCustomerId(int customerId);
	 * 
	 * @Query("select a from Announcement a where a.reviewer.id = ?1")
	 * Collection<Announcement> findByReviewerId(int customerId);
	 */
}
