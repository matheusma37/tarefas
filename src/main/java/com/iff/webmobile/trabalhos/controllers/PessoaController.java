package com.iff.webmobile.trabalhos.controllers;

import com.iff.webmobile.trabalhos.models.Tarefa;
import com.iff.webmobile.trabalhos.models.Pessoa;
import com.iff.webmobile.trabalhos.repositories.Grupos;
import com.iff.webmobile.trabalhos.repositories.Pessoas;
import com.iff.webmobile.trabalhos.repositories.Tarefas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {
   
    @Autowired
    Pessoas pessoas;
    
    @Autowired
    Tarefas tarefas;
    
    @Autowired
    Grupos grupos;

    @RequestMapping("")
    public ModelAndView listAll() {
        ModelAndView mv = new ModelAndView("pessoa/pessoas-list");
        mv.addObject("pessoa", new Pessoa());
        mv.addObject("grupos",grupos.findAll());
        mv.addObject("pessoas", pessoas.findAll());
        return mv;
    }
    
    @RequestMapping("/{id_grupo}")
    public ModelAndView listAll(@PathVariable Long id_grupo) {
        ModelAndView mv = new ModelAndView("pessoa/pessoas-list");
        mv.addObject("pessoa", new Pessoa());
        mv.addObject("grupos", grupos.findAll());
        mv.addObject("pessoas", grupos.getOne(id_grupo).getPessoas());
        return mv;
    }
    
    @RequestMapping(value="show/{id}", method=RequestMethod.GET)
    public ModelAndView show(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("pessoa/pessoa-show");
        mv.addObject("pessoa", pessoas.getOne(id));
        return mv;
    }

    @RequestMapping(value="",method=RequestMethod.POST)
    public String save(Pessoa pessoa) {
        if(pessoa.getId() != null){
            Tarefa tarefa = tarefas.getOne(pessoa.getTarefa().getId());
            tarefa.setPessoa(pessoa);
            tarefas.save(tarefa);
        }
        pessoas.save(pessoa);
        return "redirect:/pessoas";
    }

    @RequestMapping(value="update/{id}")
    public ModelAndView update(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("pessoa/pessoa-edit");
        Pessoa pessoa = pessoas.getOne(id);
        mv.addObject("pessoa", pessoa);
        mv.addObject("tarefas", pessoa.getGrupo().getTarefas());
        return mv;
    }

    @RequestMapping(value="/delete/{id}")
    public String delete(@PathVariable Long id) {
        Pessoa pessoa = pessoas.getOne(id);
        if(pessoa.getTarefa() != null){
            Tarefa tarefa = pessoa.getTarefa();
            tarefa.setPessoa(null);
            tarefas.save(tarefa);
        }
        pessoas.deleteById(id);
        return "redirect:/pessoas";
    }
}
