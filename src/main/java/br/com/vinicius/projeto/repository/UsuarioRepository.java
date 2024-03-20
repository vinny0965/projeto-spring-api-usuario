package br.com.vinicius.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vinicius.projeto.entitty.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{
	
}
