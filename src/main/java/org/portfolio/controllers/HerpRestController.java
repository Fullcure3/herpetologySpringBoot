package org.portfolio.controllers;

import org.portfolio.entities.Genus;
import org.portfolio.services.GenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/genus")
public class HerpRestController {
    private GenusService service;

    @Autowired
    public HerpRestController(GenusService service) {
        this.service = service;
    }

    @GetMapping(value = "/all")
    public Iterable<Genus> getAllGenuses() {
        return service.getGenuses();
    }

    @GetMapping(value = "/pages")
    public Iterable<Genus> getAllGenusesByPage(
            @RequestParam(name = "_page", defaultValue = "1") int pageNumber,
            @RequestParam(name = "_limit", defaultValue = "10")int limit) {
        return service.getGenusesByPage(pageNumber, limit);
    }

    @GetMapping(value = "/id")
    public List<Genus> getByGenusId(int id) {
        return service.getGenusbyId(id);
    }
}
