package org.portfolio.services;

import org.portfolio.dao.HerpRepository;
import org.portfolio.views.Herp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchService implements HerpService {
    private HerpRepository repository;
    private List<Herp> herpList;

    @Autowired
    public SearchService(HerpRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getListOfHerps(String commonName, String habitat) {
        herpList = repository.getMatchingHerps(commonName, habitat);
    }

    public List<Herp> getHerpList() {
        return herpList;
    }

    public void setHerpList(List<Herp> herpList) {
        this.herpList = herpList;
    }
}
