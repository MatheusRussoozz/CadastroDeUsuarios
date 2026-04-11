package com.matheus.CadastroDeUsuarios.Usuario.service;

import com.matheus.CadastroDeUsuarios.Usuario.dtos.UsuarioDtoListarInformacoes;
import com.matheus.CadastroDeUsuarios.Usuario.mapper.UsuarioMapper;
import com.matheus.CadastroDeUsuarios.Usuario.model.Usuario;
import com.matheus.CadastroDeUsuarios.Usuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    //Listar - GET
    public List<UsuarioDtoListarInformacoes> listarInformacoesUsuario(){
        List<Usuario> usuario = usuarioRepository.findAll();
        return usuario.stream()
                .map(usuarioMapper::map)
                .collect(Collectors.toList());

    }
    //Listar por id - GET
    public UsuarioDtoListarInformacoes listarInformacoesUsuarioPorID(Long id){
        if (usuarioRepository.existsById(id)) {

            Usuario usuario = usuarioRepository.findById(id).get();

            return usuarioMapper.map(usuario);
        }

        return null;
    }

    public UsuarioDtoListarInformacoes criarUsuario(UsuarioDtoListarInformacoes usuarioDto){
        Usuario usuario = usuarioMapper.map(usuarioDto);
        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.map(usuario);
    }

    public UsuarioDtoListarInformacoes atualizarUsuario(Long id, UsuarioDtoListarInformacoes usuarioDtoListarInformacoes){
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()){
            Usuario usuarioAtualizado = usuarioMapper.map(usuarioDtoListarInformacoes);
            usuarioAtualizado.setId(id);
            Usuario usuarioSalvo = usuarioRepository.save(usuarioAtualizado);
            return usuarioMapper.map(usuarioAtualizado);
        }
        return null;
    }
    public void deletarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

}
