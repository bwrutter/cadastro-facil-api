package com.api.cadastrofacil.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_cliente")
@Getter
@Setter
public class ClienteModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String cpfcnpj;
    @Column(nullable = false)
    private String data_nasc;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private String cep;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false, length = 2)
    private String uf;
    @Column
    private LocalDateTime DataRegistro;
 	@Column(nullable = false, length = 1)
    private Integer tipo;
    @Column
    private String login;
    @Column
    private String senha;
    
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
	public String getNome() {
		return nome;
	}
	public String getCpfcnpj() {
		return cpfcnpj;
	}
	public String getData_nasc() {
		return data_nasc;
	}
	public String getTelefone() {
		return telefone;
	}
	public String getEmail() {
		return email;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getCep() {
		return cep;
	}
	public String getBairro() {
		return bairro;
	}
	public String getNumero() {
		return numero;
	}
	public String getCidade() {
		return cidade;
	}
	public String getUf() {
		return uf;
	}
	public LocalDateTime getDataRegistro() {
		return DataRegistro;
	}
	public void setDataRegistro(LocalDateTime dataRegistro) {
		DataRegistro = dataRegistro;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}
	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
    
	
}
