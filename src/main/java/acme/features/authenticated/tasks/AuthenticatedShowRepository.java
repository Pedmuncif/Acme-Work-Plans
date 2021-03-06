package acme.features.authenticated.tasks;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.tasks.Task;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedShowRepository extends AbstractRepository {
	
	@Query("select t from Task t where t.id = ?1")
	Task findOneTaskById(Integer id);

}
