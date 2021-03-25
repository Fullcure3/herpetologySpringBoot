package org.portfolio.herpetology;

import org.portfolio.services.SearchService;
import org.portfolio.undo.Command;
import org.portfolio.undo.UndoableCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HerpController {
    private SearchService herpService;
    private Command undoCommand;
    private UndoableCommand searchCommand;

    @Autowired
    public HerpController(SearchService herpService,
                          @Qualifier(value = "undoSearch") Command undoCommand,
                          @Qualifier(value = "search") UndoableCommand searchCommand) {
        this.herpService = herpService;
        this.undoCommand = undoCommand;
        this.searchCommand = searchCommand;
    }


    @GetMapping(value = "herpetology")
    public ModelAndView mainPage(
            @RequestParam(name = "commonName") String commonName,
            @RequestParam(name = "habitat") String habitat, ModelAndView modelAndView) {
        searchCommand.execute();
        var herps = herpService.getListOfHerps(commonName, habitat);
        modelAndView.setViewName("herpetology");
        modelAndView.addObject("herps", herps);
        return modelAndView;
    }

    @GetMapping(value = "undo")
    public ModelAndView undo(ModelAndView modelAndView){
        undoCommand.execute();
        var previousList = herpService.getHerpList();
        modelAndView.addObject("herps", previousList);
        modelAndView.setViewName("herpetology");
        return modelAndView;
    }
}
