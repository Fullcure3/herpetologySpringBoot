package org.portfolio.services;

import org.portfolio.dao.GenusRepository;
import org.portfolio.entities.Genus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
