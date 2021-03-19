package org.portfolio.undo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.Deque;

@Component
public class SearchHistory {
    private Deque<UndoableCommand> commands = new ArrayDeque<>();

    public void push(UndoableCommand command){
        commands.push(command);
    }
    public UndoableCommand pop(){
        return commands.pop();
    }
    public boolean isEmpty(){
        return commands.isEmpty();
    }
}
