package com.clical.client.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class EmailMessageDTO {

    @JsonProperty("email_id")
    private Integer emailId;

    @JsonProperty("client_id")
    private String clientId;

    @Email
    @JsonProperty("email_remetente")
    private String emailRemetente;

    @Email
    @JsonProperty("email_destinatario")
    private String emailDestinatario;

    @JsonProperty("assunto")
    private String assunto;

    @Lob
    @JsonProperty("corpo")
    private String corpo;

    @JsonProperty("status_email")
    private String statusEmail;

    @JsonProperty("tipo")
    private String tipo;

    @JsonProperty("data_criacao")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataCriacao;

    @JsonProperty("data_envio")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataEnvio;

    public Integer getEmailId() {
        return emailId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getEmailRemetente() {
        return emailRemetente;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getCorpo() {
        return corpo;
    }

    public String getStatusEmail() {
        return statusEmail;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setEmailId(Integer emailId) {
        this.emailId = emailId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setEmailRemetente(String emailRemetente) {
        this.emailRemetente = emailRemetente;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public void setStatusEmail(String statusEmail) {
        this.statusEmail = statusEmail;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
}
