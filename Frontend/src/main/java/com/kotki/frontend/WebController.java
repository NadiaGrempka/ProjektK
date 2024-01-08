package com.kotki.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
public class WebController {

    private final WebService service;
    private Logger logger = Logger.getLogger("Web Controller");

    @Autowired
    public WebController(WebService service) {
        this.service = service;
    }

    @GetMapping(value = "/welcome")
    public String welcome(){
        return "welcome";
    }

    @GetMapping(value = "/viewAll")
        public String viewAll(Model model){
            logger.info("Method viewAll before getAllCats");
            model.addAttribute("cats", service.getAllCats());
            return "index";
        }

    @GetMapping(value = "/addCat")
    public String addView(Model model){
        logger.info("GetMapping addCat");
        model.addAttribute("cat", new Cat("",0));
        return "addCat";
    }

    @RequestMapping(value = "/addCat", method = RequestMethod.POST)
    public String addCat(Cat cat, Model model){
        logger.info("RequestMapping addCat");
        logger.info("RequestMapping addCat: " + cat.name +" age: " + cat.age);
        if (cat.getAge()<= 0){
            model.addAttribute("message", "Podano zły wiek");
        } else if (cat.getName().equals("") || cat.getName().contains(" ")) {
            model.addAttribute("message", "Podane niepoprawne imię");
        }else {
            service.addNewCat(cat);
        }
        return "redirect:/viewAll";
    }

    @GetMapping(value = "/editCat/{id}")
    public String editView(Model model, @PathVariable("id") long id){
        model.addAttribute("cat", service.getCatId(id));
        return "editCat";
    }

    @RequestMapping(value = "/editCat/{id}", method = RequestMethod.POST)
    public String editCat(Cat cat, Model model, @PathVariable("id") long id){
        if (cat.getAge()<=0){
            model.addAttribute("message", "Podano zły wiek");
        } else if (cat.getName().equals("") || cat.getName().contains(" ")) {
            model.addAttribute("message", "Podano niepoprawne imię");
        }else {
            service.updateCat(cat);
        }
        return "redirect:/viewAll";
    }

    @GetMapping(value = "/deleteCat/{id}")
    public String deleteView(Model model, @PathVariable("id") long id){
        model.addAttribute("cat", service.getCatId(id));
        return "deleteCat";
    }

    @RequestMapping(value = "/deleteCat/{id}")
    public String deleteCat(@ModelAttribute Cat cat, Model model, @PathVariable("id") long id){
        service.deleteById(cat.getId());
        return "redirect:/viewAll";
    }


}
