package org.portfolio.dao;

import org.portfolio.views.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User getUserByUsernameAndPassword(String username, String password);
}
