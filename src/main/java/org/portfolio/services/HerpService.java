package org.portfolio.services;

import org.portfolio.views.HerpView;

import java.util.List;

public interface HerpService {
    List<HerpView> getListOfHerps(String commonName, String habitat);
}
