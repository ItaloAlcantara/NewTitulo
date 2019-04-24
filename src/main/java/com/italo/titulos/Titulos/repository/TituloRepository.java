package com.italo.titulos.Titulos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.italo.titulos.Titulos.model.Titulo;

@Repository
public interface TituloRepository extends CrudRepository<Titulo, Long>{

}
