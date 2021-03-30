package org.portfolio.controllers;

import org.portfolio.services.SearchService;
import org.portfolio.undo.Command;
import org.portfolio.undo.UndoableCommand;
import org.portfolio.views.HerpView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HerpViewController {
    private SearchService herpService;
    private Command undoCommand;
    private UndoableCommand searchCommand;

    @Autowired
    public HerpViewController(SearchService herpService,
                              @Qualifier(value = "undoSearch") Command undoCommand,
                              @Qualifier(value = "search") UndoableCommand searchCommand) {
        this.herpService = herpService;
        this.undoCommand = undoCommand;
        this.searchCommand = searchCommand;
    }


    @GetMapping(value = "/herpetology")
    public ModelAndView mainPage(
            @RequestParam(name = "commonName") String commonName,
            @RequestParam(name = "habitat") String habitat, ModelAndView modelAndView) {
        return loadHerpView(modelAndView, getHerpSearch(commonName, habitat));
    }

    @GetMapping(value = "/undo")
    public ModelAndView undo(ModelAndView modelAndView){
        return loadHerpView(modelAndView, previousHerpSearch());
    }

    private List<HerpView> getHerpSearch(String commonName, String habitat) {
        searchCommand.execute();
        var herps = herpService.getListOfHerps(commonName, habitat);
        return herps;
    }

    private List<HerpView> previousHerpSearch() {
        undoCommand.execute();
        return herpService.getHerpList();
    }

    private ModelAndView createModel(ModelAndView modelAndView, List<HerpView> herpSearch) {
        modelAndView.addObject("herps", herpSearch);
        modelAndView.setViewName("herpetology");
        return modelAndView;
    }

    private ModelAndView loadHerpView(ModelAndView modelAndView, List<HerpView> herpSearch) {
        return createModel(modelAndView, herpSearch);
    }
}
