package com.italo.titulos.Titulos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.italo.titulos.Titulos.model.Pessoa;
import com.italo.titulos.Titulos.service.PessoaService;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping("/novo")
	public ModelAndView index(Pessoa pessoa) {
		return pessoaService.pessoa(pessoa);
	}
		
	@PostMapping
	public String adicionarPessoas(Pessoa pessoa,RedirectAttributes attributes) {
		return pessoaService.adicionarPessoa(pessoa, attributes);
	}
		
}
