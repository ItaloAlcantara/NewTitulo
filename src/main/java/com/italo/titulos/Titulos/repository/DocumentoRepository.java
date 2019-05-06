package com.italo.titulos.Titulos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.italo.titulos.Titulos.model.Documento;
@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long>{

}
