package com.italo.titulos.Titulos.service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
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
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private TitulosRepository tituloRepository;
	@InitBinder
	
	
	public String salvar(Titulo titulo, RedirectAttributes attributes) {		
		ModelAndView mv =new ModelAndView(VIEW_CADASTRO);
		attributes.addFlashAttribute("menssagem","titulo salvo com sucesso!");				
		titulo.setDataInclusao(Calendar.getInstance());
		tituloRepository.save(titulo);
		return "redirect:/titulos/novo";
	}

	public ModelAndView Titulos(Titulo titulo) {
		ModelAndView mv = new ModelAndView(VIEW_CADASTRO);
		mv.addObject(new Titulo());
		return mv;
	}
	
	 public ModelAndView ListarTodosTitulos(Titulo titulo) {
		 ModelAndView mv =new ModelAndView(VIEW_LISTAR);
		 
		 List<Titulo> titulos= (List<Titulo>) tituloRepository.findByDataExclusaoIsNull();		 
		 mv.addObject("titulos",titulos);
		 return mv;
	 }
	 public ModelAndView Editar(Titulo titulo) {
		 ModelAndView mv = new ModelAndView(VIEW_CADASTRO);
		 titulo.setDataEdicao(Calendar.getInstance());
		 mv.addObject(titulo);
		 return mv;
	 }
	 
	 public String Excluir(Titulo titulo) {
		 titulo.setDataExclusao(Calendar.getInstance());
		 titulo.setStatus(TipoStatus.DESATIVADO);
		 titulo.setDataEdicao(Calendar.getInstance());
		 return "redirect:/titulos";
	 }
	
	public List<TipoStatus> tipoStatusTitulo(){
		return Arrays.asList(TipoStatus.values()).stream().filter(status -> !status.equals(TipoStatus.DESATIVADO)).collect(Collectors.toList());
	}
	
	
	
	
}
