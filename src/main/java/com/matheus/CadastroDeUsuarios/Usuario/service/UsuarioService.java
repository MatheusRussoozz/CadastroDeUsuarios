package com.matheus.CadastroDeUsuarios.Usuario.service;

import com.matheus.CadastroDeUsuarios.Usuario.Exceptions.EmailDuplicadoException;
import com.matheus.CadastroDeUsuarios.Usuario.dtos.UsuarioDto;
import com.matheus.CadastroDeUsuarios.Usuario.dtos.UsuarioDtoListarInformacoes;
import com.matheus.CadastroDeUsuarios.Usuario.mapper.UsuarioMapper;
import com.matheus.CadastroDeUsuarios.Usuario.mapper.UsuarioMapperInfos;
import com.matheus.CadastroDeUsuarios.Usuario.model.Usuario;
import com.matheus.CadastroDeUsuarios.Usuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapperInfos usuarioMapper;
    private final UsuarioMapper usuarioDtoMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapperInfos usuarioMapper, UsuarioMapper usuarioDtoMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.usuarioDtoMapper = usuarioDtoMapper;
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

    public UsuarioDto criarUsuario(UsuarioDto usuarioDto){
        if(usuarioRepository.existsByEmail(usuarioDto.getEmail())){
            throw new EmailDuplicadoException("Email já cadastrado");
        }
        Usuario usuario = usuarioDtoMapper.map(usuarioDto);
        usuario = usuarioRepository.save(usuario);
        return usuarioDtoMapper.map(usuario);
    }

    public UsuarioDto atualizarUsuario(Long id, UsuarioDto usuarioDto){
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()){
            Usuario usuarioAtualizado = usuarioDtoMapper.map(usuarioDto);
            usuarioAtualizado.setId(id);
            Usuario usuarioSalvo = usuarioRepository.save(usuarioAtualizado);
            return usuarioDtoMapper.map(usuarioAtualizado);
        }
        return null;
    }
    public void deletarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

}
