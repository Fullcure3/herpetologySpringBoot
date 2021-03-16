package org.portfolio.dao;

import org.portfolio.views.Herp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HerpRepository extends CrudRepository<Herp, Integer> {

    @Query(nativeQuery = true, value = "CALL getMatchingHerps(:commonName, :habitat)")
    List<Herp> getMatchingHerps(String commonName, String habitat);
}
