package org.portfolio.dao;

import org.portfolio.views.HerpView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HerpRepository extends CrudRepository<HerpView, Integer> {

    @Query(nativeQuery = true, value = "CALL getMatchingHerps(:commonName, :habitat)")
    List<HerpView> getMatchingHerps(String commonName, String habitat);
}
