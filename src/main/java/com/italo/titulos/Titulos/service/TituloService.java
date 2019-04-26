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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.italo.titulos.Titulos.model.TipoStatus;
import com.italo.titulos.Titulos.model.Titulo;
import com.italo.titulos.Titulos.repository.TituloRepository;


@Service
@Transactional
public class TituloService {
	
	private static final String VIEW_CADASTRO=("CadastroTitulo");
	private static final String VIEW_LISTAR=("PesquisaTitulos");
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private TituloRepository tituloRepository;
	@InitBinder
	
	
	public String salvar(Titulo titulo, RedirectAttributes attributes) {		
		ModelAndView mv =new ModelAndView(VIEW_CADASTRO);
		attributes.addFlashAttribute("menssagem","titulo salvo com sucesso!");				
		Titulo tituloDB=titulo;
		tituloDB.setDataInclusao(Calendar.getInstance());
		tituloRepository.save(tituloDB);
		return "redirect:/titulos/novo";
	}

	public ModelAndView Titulos(Titulo titulo) {
		ModelAndView mv = new ModelAndView(VIEW_CADASTRO);
		mv.addObject(new Titulo());
		return mv;
	}
	
	 public ModelAndView ListarTodosTitulos(Titulo titulo) {
		 ModelAndView mv =new ModelAndView(VIEW_LISTAR);
		 List<Titulo> titulos= (List<Titulo>) tituloRepository.findAll();
		 mv.addObject("titulos",titulos);
		 return mv;
	 }
	
	public List<TipoStatus> tipoStatusTitulo(){
		return Arrays.asList(TipoStatus.values()).stream().filter(status -> !status.equals(TipoStatus.DESATIVADO)).collect(Collectors.toList());
	}
}
