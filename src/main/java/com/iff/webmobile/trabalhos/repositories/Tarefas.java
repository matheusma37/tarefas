package com.iff.webmobile.trabalhos.repositories;

import com.iff.webmobile.trabalhos.models.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Tarefas extends JpaRepository<Tarefa, Long>{
}
