package com.clical.client.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "servico",uniqueConstraints = @UniqueConstraint(columnNames = {"nome"}))
@NoArgsConstructor
@AllArgsConstructor
public class Servico implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_servico")
    private Integer idServico;

    @NotBlank
    @Column(name="nome")
    private String nome;

    @NotBlank
    @Column(name="descricao")
    private String descricao;

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
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
}
