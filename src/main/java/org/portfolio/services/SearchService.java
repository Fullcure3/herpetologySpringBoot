package org.portfolio.services;

import org.portfolio.dao.HerpViewRepository;
import org.portfolio.views.HerpView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService implements HerpService {
    private HerpViewRepository repository;
    private List<HerpView> herpViewList;

    @Autowired
    public SearchService(HerpViewRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<HerpView> getListOfHerps(String commonName, String habitat) {
        herpViewList = repository.getMatchingHerps(commonName, habitat);
        return herpViewList;
    }

    public List<HerpView> getHerpList() {
        return herpViewList;
    }

    public void setHerpList(List<HerpView> herpViewList) {
        this.herpViewList = herpViewList;
    }
}
