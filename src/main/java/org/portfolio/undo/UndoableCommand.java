package org.portfolio.undo;

public interface UndoableCommand extends Command{
    void unexecute();
}
