package br.com.lfa.AppPessoas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pessoas")
public class Pessoas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
	private Long id;
	
	@Column(nullable = false) //not null
	private String nome;
	
	@Column
	private String endereco;
	
	@Column(nullable = false) //not null
    private String cep;
	
	@Column(nullable = false) //not null
    private String cidade;
	
	@Column(nullable = false) //not null
    private String uf;
    
    public Pessoas() { }

	public Pessoas(Long id, String nome, String endereco, String cep, String cidade, String uf) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	@Override
	public String toString() {
		String retorno = "[" + "ID: " + this.id + ", " + "Nome: " + this.nome + ", "
				+ "Endereço: " + this.endereco + ", " + "CEP: " + this.cep + ", "
				+ "Cidade: " + this.cidade + ", " + "UF: " + this.uf + "]";
		return retorno;
	}  
}
