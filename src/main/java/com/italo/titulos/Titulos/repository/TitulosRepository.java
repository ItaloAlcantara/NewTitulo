package com.italo.titulos.Titulos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.italo.titulos.Titulos.model.Titulo;
@Repository("TitulosRepository")
public interface TitulosRepository extends JpaRepository<Titulo, Long> {
	
	public List<Titulo> findByDataExclusaoIsNull();

}
