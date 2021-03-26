package org.portfolio.dao;

import org.portfolio.entities.Genus;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenusRepository extends PagingAndSortingRepository<Genus, Integer> {
    List<Genus> getAllByGenusId(int genusId);
}
