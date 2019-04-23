package com.italo.titulos.Titulos.model;

public enum TipoStatus {

	ATIVO("Ativo"),
	DESATIVADO("Desativado");
	
	private final String descricao;
	
	private TipoStatus(String descricao) {
		this.descricao=descricao;
	}
	public String getDescricao() {
		return descricao;
	}
}
