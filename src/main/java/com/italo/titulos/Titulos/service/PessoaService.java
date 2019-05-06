package com.italo.titulos.Titulos.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.italo.titulos.Titulos.model.Pessoa;
import com.italo.titulos.Titulos.model.TipoStatus;
import com.italo.titulos.Titulos.repository.PessoaRepository;


@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
		
	private static final String VIEW_CADASTRO=("CadastroPessoa");
	private static final String VIEW_LISTAR=("PesquisaPessoa");
	private static final String OPERACAO_CONCLUIDA=("Operação realizada com sucesso!");
	
	public ModelAndView pessoas(Pessoa pessoa) {
		ModelAndView mv = new ModelAndView(VIEW_LISTAR);
		List<Pessoa> pessoas = (List<Pessoa>)pessoaRepository.findAll().stream().filter(pessoax -> !pessoax.isDesativado());
		mv.addObject("pessoas", pessoas);
		return mv;
	}
	
	public String adicionarPessoa(Pessoa pessoa, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView(VIEW_CADASTRO);
		attributes.addFlashAttribute("menssagem",OPERACAO_CONCLUIDA);	
		pessoa.setDataInclusao(Calendar.getInstance());
		pessoaRepository.save(pessoa);		
		return "redirect:/pessoa/novo";
	}
	
	public String excluirPessoa(Pessoa pessoa, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView(VIEW_LISTAR);
		pessoa.setDataExclusao(Calendar.getInstance());
		pessoa.setDataEdicao(Calendar.getInstance());
		pessoa.setStatus(TipoStatus.DESATIVADO);
		redirectAttributes.addFlashAttribute("menssagem",OPERACAO_CONCLUIDA);
		return "redirect:/pessoa";
	}
	
	public String editarPessoa(Pessoa pessoa,RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView(VIEW_CADASTRO);
		pessoa.setDataEdicao(Calendar.getInstance());
		pessoaRepository.save(pessoa);
		redirectAttributes.addFlashAttribute("menssagem",OPERACAO_CONCLUIDA);
		return "redirect:/pessoa";
	}
}
