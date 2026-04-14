package com.matheus.CadastroDeUsuarios.Tarefas.dtos;

import com.matheus.CadastroDeUsuarios.Tarefas.model.Status;
import com.matheus.CadastroDeUsuarios.Usuario.model.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarefaDtoInfos {

    private Long id;
    private String nome;
    private String descricao;
    private Status status;


}
