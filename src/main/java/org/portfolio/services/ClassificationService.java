package org.portfolio.services;

import org.portfolio.dao.ClassificationRepository;
import org.portfolio.page.ClassificationViewPage;
import org.portfolio.views.ClassificationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ClassificationService {
    private ClassificationRepository repository;
    @Autowired
    public ClassificationService(ClassificationRepository repository) {
        this.repository = repository;
    }

    public Page<ClassificationView> getClassifications(int pageNumber, int pageSize){
        return repository.findAll(ClassificationViewPage.getPage(pageNumber, pageSize));
    }




}
