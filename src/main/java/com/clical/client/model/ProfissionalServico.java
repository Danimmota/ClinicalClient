package com.clical.client.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name="profissional_servico")
@NoArgsConstructor
@AllArgsConstructor
public class ProfissionalServico implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ProfissionalServicoId profissionalServicoId;

    public ProfissionalServicoId getProfissionalServicoId() {
        return profissionalServicoId;
    }

    public void setProfissionalServicoId(ProfissionalServicoId profissionalServicoId) {
        this.profissionalServicoId = profissionalServicoId;
    }
}
