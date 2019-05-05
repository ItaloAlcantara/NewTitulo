package com.italo.titulos.Titulos.model;

public enum Tipo {
	
	PESSOAL("Pessoal"),
	COMERCIAL("Comercial"),
	EMPRESARIAL("Empresarial");
	
	private  final String descricao;
	
	private Tipo(String descricao) {
		this.descricao=descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
