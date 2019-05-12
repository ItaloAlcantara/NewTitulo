package com.italo.titulos.Titulos.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.italo.titulos.Titulos.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query ("select u from Usuario u where u.usuario like  ?1")
	Usuario findUsuarioByLogin(String username);


}
