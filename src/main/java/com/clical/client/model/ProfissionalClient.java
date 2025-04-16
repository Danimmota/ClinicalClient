package com.clical.client.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name="profissional_client")
@NoArgsConstructor
@AllArgsConstructor
public class ProfissionalClient implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ProfissionalClientId profissionalClientId;

    public ProfissionalClientId getProfissionalClientId() {
        return profissionalClientId;
    }

    public void setProfissionalClienteId(ProfissionalClientId profissionalClientId) {
        this.profissionalClientId = profissionalClientId;
    }
}
