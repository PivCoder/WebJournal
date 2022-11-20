package Repositoryes;

import model.Authorization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorizationRepository  extends CrudRepository<Authorization, Integer> {
}
