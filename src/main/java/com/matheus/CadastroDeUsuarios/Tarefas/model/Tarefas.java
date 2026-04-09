package com.matheus.CadastroDeUsuarios.Tarefas.model;

import com.matheus.CadastroDeUsuarios.Usuario.model.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_tarefas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarefas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "status")
    private Status status;

    @OneToMany(mappedBy = "tb_usuarios")
    private List<Usuario> usuarios;




}
