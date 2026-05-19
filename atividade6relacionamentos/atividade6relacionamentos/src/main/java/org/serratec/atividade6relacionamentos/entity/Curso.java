package org.serratec.atividade6relacionamentos.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    private String descricao;

    @DecimalMin("0.00")
    private BigDecimal preco;

    @ManyToMany
    @JoinTable(
        name = "curso_aluno",
        joinColumns = @JoinColumn(name = "id_curso"),
        inverseJoinColumns = @JoinColumn(name = "id_aluno")
    )
    private List<Aluno> alunos;

    @OneToMany(mappedBy = "curso", fetch = FetchType.EAGER)
    private List<Topico> topicos;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Topico> getTopicos() {
        return topicos;
    }

    public void setTopicos(List<Topico> topicos) {
        this.topicos = topicos;
    }
}