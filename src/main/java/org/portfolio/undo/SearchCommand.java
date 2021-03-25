package org.portfolio.undo;

import org.portfolio.services.SearchService;
import org.portfolio.views.Herp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Qualifier(value = "search")
public class SearchCommand implements UndoableCommand{
    private List<Herp> herps;
    private SearchService service;
    private SearchHistory history;

    @Autowired
    public SearchCommand(SearchService service, SearchHistory history) {
        this.service = service;
        this.history = history;
    }


    @Override
    public void execute() {
        herps = service.getHerpList();
        history.push(this);
    }

    @Override
    public void unexecute() {
        service.setHerpList(herps);
    }
}
