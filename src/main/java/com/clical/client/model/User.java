package com.clical.client.model;

import com.clical.client.model.enums.UserPerfil;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="user", uniqueConstraints = @UniqueConstraint(columnNames = {"email", "login"}))
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Id
    @Column(name="id_user")
    private UUID idUser;

    @NotBlank
    @Column(name="nome")
    private String nome;

    @NotBlank
    @Column(name="telefone")
    private String telefone;

    @NotBlank
    @Email
    @Column(name="email")
    private String email;

    @Column(name="login")
    private String login;

    @NotBlank
    @Column(name="senha")
    private String senha;

    @NotBlank
    @Enumerated(EnumType.STRING) //ENUM
    @Column(name="perfil")
    private UserPerfil perfil;

    @Column(name="criacao_usuario")
    private LocalDateTime criacaoUsuario;

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UserPerfil getPerfil() {
        return perfil;
    }

    public void setPerfil(UserPerfil perfil) {
        this.perfil = perfil;
    }

    public LocalDateTime getCriacaoUsuario() {
        return criacaoUsuario;
    }

    public void setCriacaoUsuario(LocalDateTime criacaoUsuario) {
        this.criacaoUsuario = criacaoUsuario;
    }
}
