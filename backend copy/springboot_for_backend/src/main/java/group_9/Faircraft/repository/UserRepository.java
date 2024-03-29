package group_9.Faircraft.repository;


import group_9.Faircraft.Model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	User findByEmail(String email);
	
}
