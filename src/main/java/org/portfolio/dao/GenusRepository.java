package org.portfolio.dao;

import org.portfolio.entities.Genus;
import org.portfolio.entities.Herp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenusRepository extends PagingAndSortingRepository<Genus, Integer> {
    List<Genus> getAllByGenusId(int genusId);
}
