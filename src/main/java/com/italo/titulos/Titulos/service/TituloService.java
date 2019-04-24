package com.italo.titulos.Titulos.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.italo.titulos.Titulos.model.TipoStatus;
import com.italo.titulos.Titulos.model.Titulo;
import com.italo.titulos.Titulos.repository.TituloRepository;

@Service
@Transactional
public class TituloService {
	
	private static final String VIEW_CADASTRO=("CadastroTitulo");
	
	@Autowired
	private TituloRepository tituloRepository;
	
	public ModelAndView salvar(Titulo titulo) {
		
		ModelAndView mv =new ModelAndView(VIEW_CADASTRO);
		mv.addObject("menssagem","titulo salvo com sucesso!");
		Titulo tituloDB=titulo;
		tituloDB.setDataInclusao(Calendar.getInstance());
		tituloRepository.save(tituloDB);
		return mv;
	}

	public ModelAndView Titulos(Titulo titulo) {
		ModelAndView mv = new ModelAndView(VIEW_CADASTRO);
		return mv;
	}
	
	
}
