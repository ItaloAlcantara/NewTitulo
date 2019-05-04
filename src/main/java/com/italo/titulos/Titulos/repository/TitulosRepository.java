package com.italo.titulos.Titulos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.italo.titulos.Titulos.model.Titulo;
@Repository("TitulosRepository")
public interface TitulosRepository extends JpaRepository<Titulo, Long> {
	
	public List<Titulo> findByDataExclusaoIsNull();
	
	@Query("select t from Titulo t where t.descricao like %?1% and t.dataExclusao is null")
	public List<Titulo> pesquisaTitulosPorDescricao(String descricao);
}
