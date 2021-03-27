package org.portfolio.page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class ClassificationViewPage {
    private static int pageNumber = 0;
    private static int pageSize = 10;
    private static Sort.Direction sortDirection = Sort.Direction.ASC;
    private static String sortBy = "commonName";

    public static Pageable getPage() {
        var sort = Sort.by(sortDirection, sortBy);
        return PageRequest.of(pageNumber, pageSize, sort);
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Sort.Direction getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(Sort.Direction sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}
