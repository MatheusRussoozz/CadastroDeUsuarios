package com.matheus.CadastroDeUsuarios.Usuario.dtos;

import com.matheus.CadastroDeUsuarios.Tarefas.model.Tarefas;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDtoListarInformacoes {

    private Long id;
    private String nome;
    private String email;
    private Tarefas tarefas;

}
