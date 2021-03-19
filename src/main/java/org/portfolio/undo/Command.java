package org.portfolio.undo;

public interface Command {
    void execute(String commonName, String habitat);
}
