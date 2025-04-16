package com.clical.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProfissionalClienteDTO {

    @JsonProperty("profissional_id")
    private String profissionalId;

    @JsonProperty("client_id")
    private String clientId;

    public String getProfissionalId() {
        return profissionalId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setProfissionalId(String profissionalId) {
        this.profissionalId = profissionalId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
