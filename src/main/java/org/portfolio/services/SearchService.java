package org.portfolio.services;

import org.portfolio.dao.HerpRepository;
import org.portfolio.views.Herp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class SearchService implements HerpService {
    private HerpRepository repository;

    @Autowired
    public SearchService(HerpRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Herp> getListOfHerps(String commonName, String habitat) {
        return repository.getMatchingHerps(commonName, habitat);
    }
}
