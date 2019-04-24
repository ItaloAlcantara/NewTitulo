package com.italo.titulos.Titulos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.italo.titulos.Titulos.model.Titulo;
import com.italo.titulos.Titulos.service.TituloService;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	@Autowired
	private TituloService tituloService;
	
	@GetMapping
	public String inxe() {
		return "CadastroTitulo";
	}
	
	@PostMapping
	public String salvar(Titulo titulo) {
		return tituloService.salvar(titulo);
	}
	
}
