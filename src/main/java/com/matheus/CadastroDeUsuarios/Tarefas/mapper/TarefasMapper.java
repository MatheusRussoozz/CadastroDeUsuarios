package com.matheus.CadastroDeUsuarios.Tarefas.mapper;

import com.matheus.CadastroDeUsuarios.Tarefas.dtos.TarefaDtoInfos;
import com.matheus.CadastroDeUsuarios.Tarefas.model.Tarefas;
import org.springframework.stereotype.Component;

@Component
public class TarefasMapper {

    public TarefaDtoInfos toDto(Tarefas tarefas){
        TarefaDtoInfos tarefaDto = new TarefaDtoInfos();
        tarefaDto.setId(tarefas.getId());
        tarefaDto.setNome(tarefas.getNome());
        tarefaDto.setDescricao(tarefas.getDescricao());
        tarefaDto.setStatus(tarefas.getStatus());

        return tarefaDto;
    }

    public Tarefas toEntity(TarefaDtoInfos tarefasDto){
        Tarefas tarefas = new Tarefas();

        tarefas.setId(tarefasDto.getId());
        tarefas.setNome(tarefasDto.getNome());
        tarefas.setDescricao(tarefasDto.getDescricao());
        tarefas.setStatus(tarefasDto.getStatus());

        return tarefas;
    }



}
