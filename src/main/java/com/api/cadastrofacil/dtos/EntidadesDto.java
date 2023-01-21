package com.api.cadastrofacil.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntidadesDto {
	
    private String nome;
    private String cpfcnpj;
    private String data_nasc;
    private String telefone;
    private String email;
    private String endereco;
    private String cep;
    private String bairro;
    private String numero;
    private String cidade;
    private String uf;
    private Integer tipo;	    
    
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
	public Integer getTipo() {
		return tipo;
	}
    
}
