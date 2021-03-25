package org.portfolio.services;

import org.portfolio.views.Herp;

import java.util.List;

public interface HerpService {
    List<Herp> getListOfHerps(String commonName, String habitat);
}
