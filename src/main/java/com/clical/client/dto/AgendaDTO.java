package com.clical.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.time.LocalDateTime;

public class AgendaDTO {

    @JsonProperty("id_agenda")
    private Integer id_agenda;

    @JsonProperty("cpf_profissional")
    private String cpfProfissional;

    @JsonProperty("data_hora_inicio")
    private LocalDateTime dataHoraInicio;

    @JsonProperty("data_hora_fim")
    private LocalDateTime dataHoraFim;

    public Integer getId_agenda() {
        return id_agenda;
    }

    public void setId_agenda(Integer id_agenda) {
        this.id_agenda = id_agenda;
    }

    public String getCpfProfissional() {
        return cpfProfissional;
    }

    public void setCpfProfissional(String cpfProfissional) {
        this.cpfProfissional = cpfProfissional;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }
}
