package com.iff.webmobile.tarefas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class TrabalhosController {
    
    @RequestMapping("")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("index");
        return (mv);
    }
}
