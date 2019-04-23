package com.italo.titulos.Titulos.Annotation;


@interface  AnotacaoPadrao {
	
	String message() default "Valor não pode ser maior que 9.999.999.999.999";
	
}
