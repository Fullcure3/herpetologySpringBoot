package org.portfolio.services;

import org.portfolio.dao.GenusRepository;
import org.portfolio.entities.Genus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

    public List<Genus> getGenusbyId(Integer id){
        return repository.getAllByGenusId(id);
    }

    public Iterable<Genus> getGenusesByPage(int pageNumber, int limit){
        var page = PageRequest.of(pageNumber,limit);
        return repository.findAll(page).getContent();
    }

    public void addGenus(Genus genus){
        repository.save(genus);
    }

    public void updateGenus(Integer genusId, Genus genus){
        genus.setGenusId(genusId);
        repository.save(genus);
    }

    public Genus deleteGenus(Integer genusId){
        var genus = repository.findById(genusId).get();
        repository.delete(genus);
        return genus;
    }
}
