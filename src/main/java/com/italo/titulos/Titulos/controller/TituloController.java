package com.italo.titulos.Titulos.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.italo.titulos.Titulos.model.TipoStatus;
import com.italo.titulos.Titulos.model.Titulo;
import com.italo.titulos.Titulos.service.TituloService;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	@Autowired
	private TituloService tituloService;
	
	@GetMapping("/novo")
	public ModelAndView index(Titulo titulo) {
		return tituloService.Titulos(titulo);
	}
	
	@PostMapping
	public ModelAndView salvar(Titulo titulo) {
		return tituloService.salvar(titulo);
	}
	
	@ModelAttribute("tipoStatus")
	public List<TipoStatus> tipoStatusTitulo(){
		return tituloService.tipoStatusTitulo();
	}
	
	@GetMapping()
	public String TitulosCadastrados() {
		return "PesquisaTitulos";
	}
}
