package org.portfolio.controllers;

import org.portfolio.entities.Genus;
import org.portfolio.services.GenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/genus")
public class HerpRestController {
    private GenusService service;

    @Autowired
    public HerpRestController(GenusService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Genus> getAllGenuses() {
        return service.getGenuses();
    }
}
