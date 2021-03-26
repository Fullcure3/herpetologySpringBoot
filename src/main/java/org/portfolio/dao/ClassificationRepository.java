package org.portfolio.dao;

import org.portfolio.views.ClassificationView;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationRepository extends PagingAndSortingRepository<ClassificationView, Integer> {
}
