package com.clical.client.model;

import jakarta.persistence.*;

@Embeddable
public class ProfissionalServicoId {

    @Column(name="profissional_id")
    private String profissionalId;

    @Column(name="servico_id")
    private Integer servicoId;

    public String getProfissionalId() {
        return profissionalId;
    }

    public void setProfissionalId(String profissionalId) {
        this.profissionalId = profissionalId;
    }

    public Integer getServicoId() {
        return servicoId;
    }

    public void setServicoId(Integer servicoId) {
        this.servicoId = servicoId;
    }
}
