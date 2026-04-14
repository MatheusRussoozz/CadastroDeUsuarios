package com.matheus.CadastroDeUsuarios.Tarefas.web;

import com.matheus.CadastroDeUsuarios.Tarefas.dtos.TarefaDtoInfos;
import com.matheus.CadastroDeUsuarios.Tarefas.model.Status;
import com.matheus.CadastroDeUsuarios.Tarefas.model.Tarefas;
import com.matheus.CadastroDeUsuarios.Tarefas.service.TarefasService;
import com.matheus.CadastroDeUsuarios.Usuario.dtos.UsuarioDto;
import com.matheus.CadastroDeUsuarios.Usuario.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSException;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {
    private final TarefasService tarefasService;

    public TarefasController(TarefasService tarefasService) {
        this.tarefasService = tarefasService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TarefaDtoInfos>> listarTarefas(){
        List<TarefaDtoInfos> tarefaDtoInfos =
                tarefasService.listarTarefas();
        return ResponseEntity.ok(tarefaDtoInfos);

    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<TarefaDtoInfos> listarTarefaPorId(@PathVariable Long id){

        TarefaDtoInfos tarefaPorId = tarefasService.listarTarefaPorId(id);
        if (tarefaPorId != null){
            return ResponseEntity.ok(tarefaPorId);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .build();

    }

    @PostMapping("/criar")
    public ResponseEntity<TarefaDtoInfos> criarTarefaNova(@RequestBody TarefaDtoInfos tarefaDtoInfos){
       tarefaDtoInfos = tarefasService.criarNovaTarefa(tarefaDtoInfos);
       return ResponseEntity.status(HttpStatus.CREATED)
               .body(tarefaDtoInfos);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TarefaDtoInfos> alterarStatus(@PathVariable Long id, @RequestParam Status status){

        TarefaDtoInfos tarefaAtualizada = tarefasService.alterarStatus(id, status);

        return ResponseEntity.ok(tarefaAtualizada);
    }


    @PutMapping("/atualizar/{id}")
    public ResponseEntity<TarefaDtoInfos> atualizarTarefa(@PathVariable Long id, @RequestBody TarefaDtoInfos tarefaDtoInfos){
        if (tarefasService.listarTarefaPorId(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .build();
        }
        tarefaDtoInfos.setId(id);
        TarefaDtoInfos usuarioAtualizado = tarefasService.atualizarTarefa(id,tarefaDtoInfos);
        return ResponseEntity.ok(usuarioAtualizado);
    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletartarefa(@PathVariable Long id){
        if (tarefasService.listarTarefaPorId(id) != null){
            tarefasService.deletarTarefa(id);
            return ResponseEntity.ok("Tarefa deletada com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .build();
    }


}
