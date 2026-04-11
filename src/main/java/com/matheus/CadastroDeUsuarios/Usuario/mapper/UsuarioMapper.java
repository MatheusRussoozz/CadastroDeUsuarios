package com.matheus.CadastroDeUsuarios.Usuario.mapper;

import com.matheus.CadastroDeUsuarios.Usuario.dtos.UsuarioDtoListarInformacoes;
import com.matheus.CadastroDeUsuarios.Usuario.model.Usuario;

public class UsuarioMapper {

    public Usuario map(UsuarioDtoListarInformacoes usuarioDtoListarInformacoes){
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDtoListarInformacoes.getId());
        usuario.setEmail(usuarioDtoListarInformacoes.getEmail());
        usuario.setNome(usuarioDtoListarInformacoes.getNome());
        usuario.setTarefas(usuarioDtoListarInformacoes.getTarefas());

        return usuario;
    }

    public UsuarioDtoListarInformacoes map(Usuario usuario){
        UsuarioDtoListarInformacoes usuarioDtoListarInformacoes = new UsuarioDtoListarInformacoes();
        usuarioDtoListarInformacoes.setId(usuario.getId());
        usuarioDtoListarInformacoes.setEmail(usuario.getEmail());
        usuarioDtoListarInformacoes.setNome(usuario.getNome());
        usuarioDtoListarInformacoes.setTarefas(usuario.getTarefas());

        return usuarioDtoListarInformacoes;
    }
}
