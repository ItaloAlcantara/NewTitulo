package com.italo.titulos.Titulos.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italo.titulos.Titulos.model.Titulo;
import com.italo.titulos.Titulos.repository.TituloRepository;

@Service
@Transactional
public class TituloService {
	
	@Autowired
	private TituloRepository tituloRepository;
	
	public String salvar(Titulo titulo) {
		Titulo tituloDB =titulo;
		tituloDB.setDataInclusao(Calendar.getInstance());
		tituloRepository.save(tituloDB);
		return "CadastroTitulo";
	}

}
