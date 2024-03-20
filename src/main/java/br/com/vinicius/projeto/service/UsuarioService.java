package br.com.vinicius.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vinicius.projeto.dto.UsuarioDTO;
import br.com.vinicius.projeto.entitty.UsuarioEntity;
import br.com.vinicius.projeto.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository; 

	public List<UsuarioDTO>listarTodos(){
		List<UsuarioEntity> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(UsuarioDTO::new).toList();
	}
	
	public void inserir(UsuarioDTO usuarioDTO) {
		UsuarioEntity usEntity = new UsuarioEntity(usuarioDTO);
		usuarioRepository.save(usEntity);
		
	}
	
	public UsuarioDTO alterar(UsuarioDTO usuarioDTO) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
		return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
	}
	
	public void excluir(Long id) {
		UsuarioEntity usuarioEntity = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuarioEntity);
		
	}
	
	public UsuarioDTO buscarPorId(Long id) {
		return new UsuarioDTO(usuarioRepository.findById(id).get());
		
	}
}
