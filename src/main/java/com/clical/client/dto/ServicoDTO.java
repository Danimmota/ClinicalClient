package com.clical.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServicoDTO {

    @JsonProperty("id_servico")
    private Integer idServico;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("descricao")
    private String descricao;

    public Integer getIdServico() {
        return idServico;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
