package com.matheus.CadastroDeUsuarios.Usuario.dtos;

import com.matheus.CadastroDeUsuarios.Tarefas.model.Tarefas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private Tarefas tarefas;
}
