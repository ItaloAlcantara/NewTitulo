package com.italo.titulos.Titulos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.italo.titulos.Titulos.model.Email;

public interface EmailRepository extends JpaRepository<Email, Long>{

}
