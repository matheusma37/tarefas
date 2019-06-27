package com.iff.webmobile.trabalhos.repositories;

import com.iff.webmobile.trabalhos.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pessoas extends JpaRepository<Pessoa, Long>{
}