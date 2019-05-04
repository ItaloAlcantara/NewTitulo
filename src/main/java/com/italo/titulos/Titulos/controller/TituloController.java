package com.italo.titulos.Titulos.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String salvar(@Valid Titulo titulo,RedirectAttributes attributes) {
		return tituloService.salvar(titulo,attributes);
	}
	
	@RequestMapping("{id}")
	public ModelAndView editar(@PathVariable("id") Titulo titulo,RedirectAttributes attributes) {
		return tituloService.Editar(titulo,attributes);
	}
	
	@RequestMapping(value="{id}",method = RequestMethod.DELETE)
	public String exluir(@PathVariable("id") Titulo titulo,RedirectAttributes attributes) {
		return tituloService.Excluir(titulo,attributes);
	}
	
	@ModelAttribute("tipoStatus")
	public List<TipoStatus> tipoStatusTitulo(){
		return tituloService.tipoStatusTitulo();
	}
	
	/*@GetMapping()
	public ModelAndView TitulosCadastrados(Titulo titulo) {
		return tituloService.ListarTodosTitulos(titulo);
	}*/
	@RequestMapping
	public ModelAndView pesquisaTitulosPorDescricao(@RequestParam(defaultValue = "%") String descricao) {
		return tituloService.pesquisaTitulosPorDescricao(descricao);
	}
}
