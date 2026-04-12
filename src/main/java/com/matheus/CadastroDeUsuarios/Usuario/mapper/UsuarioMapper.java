package com.matheus.CadastroDeUsuarios.Usuario.mapper;

import com.matheus.CadastroDeUsuarios.Usuario.dtos.UsuarioDto;
import com.matheus.CadastroDeUsuarios.Usuario.dtos.UsuarioDtoListarInformacoes;
import com.matheus.CadastroDeUsuarios.Usuario.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public Usuario map(UsuarioDto usuarioDto){
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDto.getId());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setNome(usuarioDto.getNome());
        usuario.setSenha(usuarioDto.getSenha());
        usuario.setTarefas(usuarioDto.getTarefas());

        return usuario;
    }

    public UsuarioDto map(Usuario usuario){
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(usuario.getId());
        usuarioDto.setEmail(usuario.getEmail());
        usuarioDto.setNome(usuario.getNome());
        usuarioDto.setSenha(usuario.getSenha());
        usuarioDto.setTarefas(usuario.getTarefas());

        return usuarioDto;
    }

}
