package com.iff.webmobile.trabalhos.models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Grupo implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "Nome é obrigatório!")
    @Column(length=100)
    private String nome;
    
    @NotNull(message = "Descrição é obrigatória!")
    @Column(length=500)
    private String descricao;
    
    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL)
    private Set<Tarefa> tarefas;
    
    @OneToMany(mappedBy = "grupo")
    private Set<Tarefa> pessoas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(Set<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public Set<Tarefa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(Set<Tarefa> pessoas) {
        this.pessoas = pessoas;
    }
    
}
