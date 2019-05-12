package com.italo.titulos.Titulos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.italo.titulos.Titulos.model.Usuario;
import com.italo.titulos.Titulos.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findUsuarioByLogin(username);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario não encontrado!");
		}
		
		return usuario;
	}

}
