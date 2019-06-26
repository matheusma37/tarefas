package com.iff.webmobile.tarefas.repositories;

import com.iff.webmobile.tarefas.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pessoas extends JpaRepository<Pessoa, Long>{
}