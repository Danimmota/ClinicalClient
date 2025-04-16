package com.clical.client.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="client")
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @CPF
    @Column(name="cpf_client")
    private String cpfClient;

    @NotBlank
    @Column(name="nome")
    private String nome;

    @NotBlank
    @Column(name="data_nascimento")
    private LocalDate dataNascimento;

    @NotBlank
    @Column(name="cep")
    private String cep;

    @NotBlank
    @Column(name="cidade")
    private String cidade;

    @NotBlank
    @Column(name="estado")
    private String estado;

    @NotBlank
    @Column(name="endereco")
    private String endereco;

    @Column(name="complemento")
    private String complemento;

    @NotBlank
    @Column(name="telefone")
    private String telefone;

    @NotBlank
    @Email
    @Column(name="email")
    private String email;

    public String getCpfClient() {
        return cpfClient;
    }

    public void setCpfClient(String cpfClient) {
        this.cpfClient = cpfClient;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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
}
