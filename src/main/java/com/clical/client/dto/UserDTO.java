package com.clical.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.clical.client.model.enums.UserPerfil;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserDTO {

    @JsonProperty("id_user")
    private UUID idUser;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("email")
    private String email;

    @JsonProperty("login")
    private String login;

    @JsonProperty("senha")
    private String senha;

    @JsonProperty("perfil")
    private UserPerfil perfil;

    @JsonProperty("criacao_usuario")
    private LocalDateTime criacao_usuario;

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setPerfil(UserPerfil perfil) {
        this.perfil = perfil;
    }

    public void setCriacao_usuario(LocalDateTime criacao_usuario) {
        this.criacao_usuario = criacao_usuario;
    }

    public UUID getIdUser() {
        return idUser;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public UserPerfil getPerfil() {
        return perfil;
    }

    public LocalDateTime getCriacao_usuario() {
        return criacao_usuario;
    }
}
