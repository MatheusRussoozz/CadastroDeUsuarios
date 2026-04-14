package com.matheus.CadastroDeUsuarios.Tarefas.service;

import com.matheus.CadastroDeUsuarios.Tarefas.dtos.TarefaDtoInfos;
import com.matheus.CadastroDeUsuarios.Tarefas.mapper.TarefasMapper;
import com.matheus.CadastroDeUsuarios.Tarefas.model.Status;
import com.matheus.CadastroDeUsuarios.Tarefas.model.Tarefas;
import com.matheus.CadastroDeUsuarios.Tarefas.repository.TarefasRepository;
import com.matheus.CadastroDeUsuarios.Usuario.dtos.UsuarioDto;
import com.matheus.CadastroDeUsuarios.Usuario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarefasService {
    private final TarefasRepository tarefasRepository;
    private final TarefasMapper tarefasMapper;

    public TarefasService(TarefasRepository tarefasRepository, TarefasMapper tarefasMapper) {
        this.tarefasRepository = tarefasRepository;
        this.tarefasMapper = tarefasMapper;
    }


    public List<TarefaDtoInfos> listarTarefas(){
        List<Tarefas> tarefasList = tarefasRepository.findAll();
                return tarefasList.stream()
                        .map(tarefasMapper::toDto)
                        .collect(Collectors.toList());
    }


    public TarefaDtoInfos listarTarefaPorId(Long id){
        if (tarefasRepository.existsById(id)){
            Tarefas tarefas = tarefasRepository.findById(id).get();

            tarefasMapper.toDto(tarefas);
        }
        return null;
    }

    public TarefaDtoInfos criarNovaTarefa(TarefaDtoInfos tarefaDtoInfos){
        Tarefas tarefas = tarefasMapper.toEntity(tarefaDtoInfos);
        tarefas = tarefasRepository.save(tarefas);
        return tarefasMapper.toDto(tarefas);
    }

    public TarefaDtoInfos atualizarTarefa(Long id, TarefaDtoInfos tarefaDtoInfos){
        Optional<Tarefas> tarefaExistente = tarefasRepository.findById(id);
        if (tarefaExistente.isPresent()){
            Tarefas tarefaAtualizada = tarefasMapper.toEntity(tarefaDtoInfos);
            tarefaAtualizada.setId(id);
            Tarefas tarefaSalva = tarefasRepository.save(tarefaAtualizada);
            return tarefasMapper.toDto(tarefaAtualizada);
        }
        return null;
    }


    public TarefaDtoInfos alterarStatus(Long id, Status alterarStatus){

        Tarefas tarefa = tarefasRepository.findById(id)
         .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        tarefa.setStatus(alterarStatus);
            Tarefas statusSalvo = tarefasRepository.save(tarefa);

            return tarefasMapper.toDto(statusSalvo);


    }

    public void deletarTarefa(Long id){
        tarefasRepository.deleteById(id);
    }
}
