package com.italo.titulos.Titulos.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.italo.titulos.Titulos.model.TipoStatus;
import com.italo.titulos.Titulos.model.Titulo;
import com.italo.titulos.Titulos.repository.TitulosRepository;




@Service
@Transactional
public class TituloService {
	
	private static final String VIEW_CADASTRO=("CadastroTitulo");
	private static final String VIEW_LISTAR=("PesquisaTitulos");
	private static final String OPERACAO_CONCLUIDA=("Operação realizada com sucesso!");
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private TitulosRepository tituloRepository;
	@InitBinder
	
	
	public String salvar(Titulo titulo, RedirectAttributes attributes) {		
		ModelAndView mv =new ModelAndView(VIEW_CADASTRO);
		attributes.addFlashAttribute("menssagem",OPERACAO_CONCLUIDA);				
		titulo.setDataInclusao(Calendar.getInstance());
		try{tituloRepository.save(titulo);
		return "redirect:/titulos/novo";
		}catch (DataIntegrityViolationException e) {
			e.getMessage();
			return VIEW_CADASTRO;
		}
		
	}

	public ModelAndView Titulos(Titulo titulo) {
		ModelAndView mv = new ModelAndView(VIEW_CADASTRO);
		mv.addObject(new Titulo());
		return mv;
	}
	
	 public ModelAndView Editar(Titulo titulo , RedirectAttributes attributes) {
		 ModelAndView mv = new ModelAndView(VIEW_CADASTRO);
		 titulo.setDataEdicao(Calendar.getInstance());
		 mv.addObject(titulo);
		 attributes.addFlashAttribute("menssagem",OPERACAO_CONCLUIDA);
		 return mv;
	 }
	 
	 public String Excluir(Titulo titulo,RedirectAttributes attributes) {
		 titulo.setDataExclusao(Calendar.getInstance());
		 titulo.setStatus(TipoStatus.DESATIVADO);
		 titulo.setDataEdicao(Calendar.getInstance());
		 attributes.addFlashAttribute("mensagem",OPERACAO_CONCLUIDA);
		 return "redirect:/titulos";
	 }
	 
	
	  public List<Titulo> VerificaDataVencimento(List<Titulo> titulos) { 
	
		  titulos.stream().filter(vencimento -> vencimento.getDataVencimento().compareTo(Calendar.getInstance()) < 0 && vencimento.getStatus().equals(TipoStatus.ATIVO)).forEach(vencimento ->vencimento.setStatus(TipoStatus.PENDENTE));			
			return titulos;
		}
		  
	public ModelAndView pesquisaTitulosPorDescricao(String descricao) {
		List<Titulo> titulos = tituloRepository.pesquisaTitulosPorDescricao(descricao);
		ModelAndView mv = new ModelAndView(VIEW_LISTAR);
		mv.addObject("titulos",VerificaDataVencimento(titulos));
		return mv;
	}  
		  
	  
	 
	
	public List<TipoStatus> tipoStatusTitulo(){
		return Arrays.asList(TipoStatus.values()).stream().filter(status -> !status.equals(TipoStatus.DESATIVADO)).collect(Collectors.toList());
	}
	
	
	
	
}
