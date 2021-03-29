package org.portfolio.controllers;

import org.portfolio.entities.Genus;
import org.portfolio.services.GenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/genus")
public class GenusRestController {
    private GenusService service;
    private int pageOffset = 1;

    @Autowired
    public GenusRestController(GenusService service) {
        this.service = service;
    }

    @DeleteMapping(value = "/{genusId}")
    @PreAuthorize(value = "hasAuthority('genus:delete')")
    public ResponseEntity<Genus> deleteCustomer(@PathVariable(name = "genusId") Integer genusId){
        try{
            var genus = service.deleteGenus(genusId);
            return ResponseEntity.ok(genus);
        }catch (Exception e){
            return ResponseEntity.status(404).body(null);
        }
    }

    @PutMapping(value = "/{genusId}")
    @PreAuthorize(value = "hasAuthority('genus:write')")
    public ResponseEntity<Genus> updateGenus(
            @PathVariable(name = "genusId") Integer genusId,
            @RequestBody Genus genus) {
        service.updateGenus(genusId, genus);
        return ResponseEntity.ok(genus);
    }

    @PostMapping(value = "/add")
    @PreAuthorize(value = "hasAuthority('genus:write')")
    public ResponseEntity<Genus> addGenus(@RequestBody Genus genus) {
        service.addGenus(genus);
        return ResponseEntity.ok(genus);
    }

    @GetMapping(value = "/all")
    @PreAuthorize(value = "hasAuthority('genus:read')")
    public Iterable<Genus> getAllGenuses() {
        return service.getGenuses();
    }

    @GetMapping(value = "/pages")
    public Iterable<Genus> getAllGenusesByPage(
            @RequestParam(name = "_page", defaultValue = "1") int pageNumber,
            @RequestParam(name = "_limit", defaultValue = "10") int limit) {
        return service.getGenusesByPage(pageNumber - pageOffset, limit);
    }

    @GetMapping(value = "/{genusId}")
    public List<Genus> getByGenusId(@RequestParam(name = "genusId", defaultValue = "1") int id) {
        return service.getGenusbyId(id);
    }
}
