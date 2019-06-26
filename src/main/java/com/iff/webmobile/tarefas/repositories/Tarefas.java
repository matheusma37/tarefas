package com.iff.webmobile.tarefas.repositories;

import com.iff.webmobile.tarefas.models.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Tarefas extends JpaRepository<Tarefa, Long>{
}
