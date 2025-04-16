package com.clical.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProfissionalDTO {

    @JsonProperty("cpf_profissional")
    private String cpfProfissional;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("registro")
    private String registro;

    @JsonProperty("especializacao")
    private String especializacao;

    @JsonProperty("rqe")
    private String rqe;

    @JsonProperty("email")
    private String email;

    @JsonProperty("endereco")
    private String endereco;

    public String getCpfProfissional() {
        return cpfProfissional;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getRegistro() {
        return registro;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public String getRqe() {
        return rqe;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setCpfProfissional(String cpfProfissional) {
        this.cpfProfissional = cpfProfissional;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public void setRqe(String rqe) {
        this.rqe = rqe;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
