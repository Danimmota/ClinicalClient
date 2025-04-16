package com.clical.client.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="agendamento")
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_agendamento")
    private Integer idAgendamento;

    @NotBlank
    @Column(name="servico_id")
    private Integer servicoId;

    @NotBlank
    @Column(name="cpf_client")
    private String cpfClient;

    @NotBlank
    @Column(name="id_agenda")
    private Integer idAgenda;

    @NotBlank
    @Column(name="date_time")
    private LocalDateTime dateTime;

    public Integer getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(Integer idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public Integer getServicoId() {
        return servicoId;
    }

    public void setServicoId(Integer servicoId) {
        this.servicoId = servicoId;
    }

    public String getCpfClient() {
        return cpfClient;
    }

    public void setCpfClient(String cpfClient) {
        this.cpfClient = cpfClient;
    }

    public Integer getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
