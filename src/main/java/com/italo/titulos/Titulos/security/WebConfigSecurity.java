package com.italo.titulos.Titulos.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.AntPathMatcher;

@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter{
	
	@Override//Configura as solicitacoes de acesso via Http
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
		.disable()//Desativa as configurações padroes de memoria do Spring
		.authorizeRequests()//Permitir restringir acessos
		.antMatchers(HttpMethod.GET,"/").permitAll()//qualquer usuario tem acesso
		.anyRequest().authenticated()
		.and().formLogin().permitAll()//qualquer usuario 
		.and().logout()//mapeia url de saida e invalida o usuario que foi autenticado
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
	@Override//cria autenticacao do usuario no BD ou em memoria
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
		.withUser("italo")
		.password("123")
		.roles("ADMIN");
	}
	
	@Override //ignora url especificas
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/static/**");
	}
	
}
