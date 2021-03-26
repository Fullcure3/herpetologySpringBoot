package org.portfolio.services;

import org.portfolio.dao.GenusRepository;
import org.portfolio.entities.Genus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class GenusService {
    private GenusRepository repository;

    @Autowired
    public GenusService(GenusRepository repository) {
        this.repository = repository;
    }

    public Iterable<Genus> getGenuses(){
        return repository.findAll();
    }
    public List<Genus> getGenusbyId(Integer id){
        return repository.getAllByGenusId(id);
    }

    public Iterable<Genus> getGenusesByPage(int pageNumber, int limit){
        var page = PageRequest.of(pageNumber,limit);
        return repository.findAll(page);
    }
}
