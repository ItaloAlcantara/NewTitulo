package com.italo.titulos.Titulos.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import com.italo.titulos.Titulos.EntityBase.EntityBase;
@Entity

public class Titulo extends EntityBase {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Size(min=3,max=60)
	private String descricao;
	
	@NotNull(message="Campo é obrigatorio!")
	@DecimalMin(value="0.01", message = "Valor deve ser maior que 1 centavo")
	@DecimalMax(value = "99999999999.99" )
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal valor;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
}