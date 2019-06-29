package com.iff.webmobile.trabalhos.controllers;

import com.iff.webmobile.trabalhos.models.Grupo;
import com.iff.webmobile.trabalhos.models.Tarefa;
import com.iff.webmobile.trabalhos.repositories.Pessoas;
import com.iff.webmobile.trabalhos.repositories.Grupos;
import com.iff.webmobile.trabalhos.repositories.Tarefas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/grupos/{id_grupo}/tarefas")
public class TarefaController {
   
    @Autowired
    Pessoas pessoas;
    
    @Autowired
    Grupos grupos;
    
    @Autowired
    Tarefas tarefas;

    @RequestMapping("")
    public ModelAndView listAll(@PathVariable Long id_grupo) {
        ModelAndView mv = new ModelAndView("tarefa/tarefas-list");
        mv.addObject("tarefa", new Tarefa());
        Grupo grupo = grupos.getOne(id_grupo);
        mv.addObject("grupo", grupo);
        mv.addObject("pessoas", grupo.getPessoas());
        mv.addObject("tarefas", grupo.getTarefas());
        return mv;
    }
    
    @RequestMapping(value="show/{id_tarefa}", method=RequestMethod.GET)
    public ModelAndView show(@PathVariable Long id_grupo, @PathVariable Long id_tarefa) {
        ModelAndView mv = new ModelAndView("tarefa/tarefa-show");
        Grupo grupo = grupos.getOne(id_grupo);
        Tarefa tarefa = null;
        
        for(Tarefa t: grupo.getTarefas()){
            if(t.getId().equals(id_tarefa)){
                tarefa = t;
            }
        }
        
        mv.addObject("grupo", grupo);
        mv.addObject("tarefa", tarefa);
        return mv;
    }

    @RequestMapping(value="",method=RequestMethod.POST)
    public String save(@PathVariable Long id_grupo, Tarefa tarefa) {
        tarefas.save(tarefa);
        return "redirect:/grupos/"+id_grupo.toString()+"/tarefas";
    }

    @RequestMapping(value="update/{id_tarefa}")
    public ModelAndView update(@PathVariable Long id_grupo, @PathVariable Long id_tarefa) {
        ModelAndView mv = new ModelAndView("tarefa/tarefa-edit");
        Grupo grupo = grupos.getOne(id_grupo);
        Tarefa tarefa = null;
        
        for(Tarefa t: grupo.getTarefas()){
            if(t.getId().equals(id_tarefa)){
                tarefa = t;
            }
        }
        
        mv.addObject("grupo", grupo);
        mv.addObject("tarefa", tarefa);
        return mv;
    }

    @RequestMapping(value="/delete/{id_tarefa}")
    public String delete(@PathVariable Long id_grupo, @PathVariable Long id_tarefa) {
        tarefas.deleteById(id_tarefa);
        return "redirect:/grupos/"+id_grupo.toString()+"/tarefas";
    }
}
