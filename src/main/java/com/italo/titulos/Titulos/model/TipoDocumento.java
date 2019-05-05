package com.italo.titulos.Titulos.model;

public enum TipoDocumento {
	
	CPF ("Cpf"),
	RG("Rg"),
	PASSAPORTE ("Passaporte"),
	OUTROS ("Outros");
	
	private final String descricao;
	
	private TipoDocumento (String descricao) {
		this.descricao=descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
