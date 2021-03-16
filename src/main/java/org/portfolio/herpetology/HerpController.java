package org.portfolio.herpetology;

import org.portfolio.services.HerpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HerpController {
    private HerpService herpService;

    @Autowired
    public HerpController(HerpService herpService) {
        this.herpService = herpService;
    }



    @GetMapping(value = "herpetology")
    public ModelAndView mainPage(
            @RequestParam(name = "commonName") String commonName,
            @RequestParam(name = "habitat") String habitat, ModelAndView modelAndView) {
//        var all = repository.findAll();
//        List<Herp> herps = repository.getHerpsByCommonNameContainsAndTypeContains(commonName, habitat);
        var herps = herpService.getListOfHerps(commonName, habitat);
//        var herps = repository.findAll();
//        var herps = herpService.getListOfHerps("sala", "ter");
        modelAndView.setViewName("herpetology");
        modelAndView.addObject("herps", herps);
        return modelAndView;
    }
}