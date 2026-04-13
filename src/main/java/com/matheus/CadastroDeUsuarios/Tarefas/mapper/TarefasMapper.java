package com.matheus.CadastroDeUsuarios.Tarefas.mapper;

import com.matheus.CadastroDeUsuarios.Tarefas.dtos.TarefaDtoInfos;
import com.matheus.CadastroDeUsuarios.Tarefas.model.Tarefas;
import org.springframework.stereotype.Component;

@Component
public class TarefasMapper {

    public Tarefas toDto(TarefaDtoInfos tarefasDto){

        Tarefas tarefas = new Tarefas();
        tarefas.setNome(tarefasDto.getNome());
        tarefas.setDescricao(tarefasDto.getDescricao());
        tarefas.setStatus(tarefasDto.getStatus());

        return tarefas;
    }

    public TarefaDtoInfos toEntity (Tarefas tarefas){
        TarefaDtoInfos tarefaDto = new TarefaDtoInfos();

        tarefaDto.setNome(tarefas.getNome());
        tarefaDto.setDescricao(tarefas.getDescricao());
        tarefaDto.setStatus(tarefas.getStatus());

        return tarefaDto;
    }

}
