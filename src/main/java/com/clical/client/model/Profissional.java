package com.clical.client.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name="profissional",uniqueConstraints = @UniqueConstraint(columnNames = {"registro"}))
@NoArgsConstructor
@AllArgsConstructor
public class Profissional implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Id
    @CPF
    @Column(name="cpf_profissional")
    private String cpfProfissional;

    @NotBlank
    @Column(name="nome")
    private String nome;

    @NotBlank
    @Column(name="telefone")
    private String telefone;

    @NotBlank
    @Column(name="registro")
    private String registro;

    @Column(name="especializacao")
    private String especializacao;

    @Column(name="rqe")
    private String rqe;

    @NotBlank
    @Email
    @Column(name="email")
    private String email;

    @Column(name="endereco")
    private String endereco;

    public String getCpfProfissional() {
        return cpfProfissional;
    }

    public void setCpfProfissional(String cpfProfissional) {
        this.cpfProfissional = cpfProfissional;
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

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public String getRqe() {
        return rqe;
    }

    public void setRqe(String rqe) {
        this.rqe = rqe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
