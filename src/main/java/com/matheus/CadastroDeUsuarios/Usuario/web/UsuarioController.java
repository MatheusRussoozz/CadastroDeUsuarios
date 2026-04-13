package com.matheus.CadastroDeUsuarios.Usuario.web;

import com.matheus.CadastroDeUsuarios.Usuario.dtos.UsuarioDto;
import com.matheus.CadastroDeUsuarios.Usuario.dtos.UsuarioDtoListarInformacoes;
import com.matheus.CadastroDeUsuarios.Usuario.model.Usuario;
import com.matheus.CadastroDeUsuarios.Usuario.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDtoListarInformacoes>> listarInformacoesCadastrados(){
        List<UsuarioDtoListarInformacoes> usuarioDtoListarInformacoes =
                usuarioService.listarInformacoesUsuario();

         return ResponseEntity.ok(usuarioDtoListarInformacoes);
    }

    @GetMapping("/listar/{id}")
    public  ResponseEntity<?> listarInformacoesPorId(@PathVariable Long id){
       UsuarioDtoListarInformacoes usuarioPorId = usuarioService.listarInformacoesUsuarioPorID(id);
       if (usuarioPorId != null){
           return ResponseEntity.ok(usuarioPorId);
       } else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("Nenhum usuario cadastrado no id "+id+" busque por um id cadastrado");
       }

    }

    @PostMapping("/criar")
    public ResponseEntity<UsuarioDto> criarUsuario(@RequestBody UsuarioDto usuarioDto){
        usuarioDto = usuarioService.criarUsuario(usuarioDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioDto);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<UsuarioDto> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto){
        if (usuarioService.listarInformacoesUsuarioPorID(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .build();
        }
        usuarioDto.setId(id);
        UsuarioDto usuarioAtualizado = usuarioService.atualizarUsuario(id,usuarioDto);
        return ResponseEntity.ok(usuarioAtualizado);
    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarUsuarioCadastrado(@PathVariable Long id){
        if (usuarioService.listarInformacoesUsuarioPorID(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .build();
        }
        usuarioService.deletarUsuario(id);
        return ResponseEntity.ok()
                .body("Usuario deletado com Sucesso!");
    }



}
