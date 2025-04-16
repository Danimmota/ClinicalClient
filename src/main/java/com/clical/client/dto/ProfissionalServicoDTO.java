package com.clical.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProfissionalServicoDTO {

    @JsonProperty("profissional_id")
    private String profissionalId;

    @JsonProperty("servico_id")
    private Integer servicoId;

    public Integer getServicoId() {
        return servicoId;
    }

    public String getProfissionalId() {
        return profissionalId;
    }

    public void setProfissionalId(String profissionalId) {
        this.profissionalId = profissionalId;
    }

    public void setServicoId(Integer servicoId) {
        this.servicoId = servicoId;
    }
}
