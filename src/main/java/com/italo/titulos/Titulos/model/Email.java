package com.italo.titulos.Titulos.model;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.italo.titulos.Titulos.EntityBase.EntityBase;
@Entity
public class Email extends EntityBase {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	@javax.validation.constraints.Email //Se der erro apagar aqui
	private String descricao;
	@ManyToOne
	private Pessoa pessoa; //Falta mapear relacionamento
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipoEmail(Tipo tipo) {
		this.tipo= tipo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Email other = (Email) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

	
}
