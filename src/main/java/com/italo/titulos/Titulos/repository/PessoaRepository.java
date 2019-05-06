package com.italo.titulos.Titulos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.italo.titulos.Titulos.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
