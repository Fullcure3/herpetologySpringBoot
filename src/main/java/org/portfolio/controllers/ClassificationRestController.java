package org.portfolio.controllers;

import org.portfolio.services.ClassificationService;
import org.portfolio.views.ClassificationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/classifications")
public class ClassificationRestController {

    private ClassificationService service;

    @Autowired
    public ClassificationRestController(ClassificationService service) {
        this.service = service;
    }

    @GetMapping(value = "/pages")
    public ResponseEntity<Page<ClassificationView>> getClassifications(
            @RequestParam(name = "page") int pageNumber,
            @RequestParam(name = "size") int pageSize) {
        return new ResponseEntity<>(service.getClassifications(pageNumber, pageSize), HttpStatus.OK);
    }

}
