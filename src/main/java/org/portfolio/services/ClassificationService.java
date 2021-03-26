package org.portfolio.services;

import org.portfolio.dao.ClassificationRepository;
import org.portfolio.page.ClassificationViewPage;
import org.portfolio.views.ClassificationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ClassificationService {
    private ClassificationRepository repository;
    @Autowired
    public ClassificationService(ClassificationRepository repository) {
        this.repository = repository;
    }

    public Page<ClassificationView> getClassifications(ClassificationViewPage classificationViewPage){
        Pageable page = createPage(classificationViewPage);
        return repository.findAll(page);
    }

    private Pageable createPage(ClassificationViewPage classificationViewPage) {
        Sort sort = Sort.by(classificationViewPage.getSortDirection(), classificationViewPage.getSortBy());
        Pageable page = PageRequest.of(classificationViewPage.getPageNumber(),
                classificationViewPage.getPageSize(), sort);
        return page;
    }


}
