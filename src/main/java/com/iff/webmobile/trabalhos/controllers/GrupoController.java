package com.iff.webmobile.trabalhos.controllers;

import com.iff.webmobile.trabalhos.models.Grupo;
import com.iff.webmobile.trabalhos.repositories.Grupos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/grupos")
public class GrupoController {
   
    @Autowired
    Grupos grupos;

    @RequestMapping("")
    public ModelAndView listAll() {
        ModelAndView mv = new ModelAndView("grupo/grupos-list");
        mv.addObject("grupo", new Grupo());
        mv.addObject("grupos",grupos.findAll());
        return mv;
    }
    
    @RequestMapping(value="show/{id}", method=RequestMethod.GET)
    public ModelAndView show(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("grupo/grupo-show");
        mv.addObject("grupo", grupos.getOne(id));
        return mv;
    }

    @RequestMapping(value="",method=RequestMethod.POST)
    public String save(Grupo grupo) {
        grupos.save(grupo);
        return "redirect:/grupos";
    }

    @RequestMapping(value="update/{id}")
    public ModelAndView update(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("grupo/grupo-edit");
        mv.addObject("grupo", grupos.getOne(id));
        return mv;
    }

    @RequestMapping(value="/delete/{id}")
    public String delete(@PathVariable Long id) {
        grupos.deleteById(id);
        return "redirect:/grupos";
    }
}
