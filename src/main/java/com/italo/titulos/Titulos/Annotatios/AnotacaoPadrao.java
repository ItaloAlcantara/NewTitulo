package com.italo.titulos.Titulos.Annotatios;

import javax.validation.constraints.DecimalMax;

public @interface AnotacaoPadrao {
	@DecimalMax(value = "99999999999.99" );
}
