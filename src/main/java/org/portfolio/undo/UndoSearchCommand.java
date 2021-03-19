package org.portfolio.undo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier(value = "undoSearch")
public class UndoSearchCommand implements Command{
    private SearchHistory history;

    @Autowired
    public UndoSearchCommand(SearchHistory history) {
        this.history = history;
    }

    @Override
    public void execute(String commonName, String habitat) {
        if(!history.isEmpty())
            history.pop().unexecute();
    }
}
