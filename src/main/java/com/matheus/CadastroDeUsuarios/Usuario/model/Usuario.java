package com.matheus.CadastroDeUsuarios.Usuario.model;

import com.matheus.CadastroDeUsuarios.Tarefas.model.Tarefas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String cpf;

    @Column(name = "senha")
    private String senha;

    @ManyToOne
    @JoinColumn(name = "tb_tarefas")
    private Tarefas tarefas;

}
