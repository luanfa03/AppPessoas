package br.com.lfa.AppPessoas.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_contato")
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
	private Long id;
	
	@Column(nullable = false)
	private Integer tipoContato; // 0 Telefone, 1 Celular
	
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true) // 1 pessoa p/ vários contatos
	@ManyToOne // vários contatos p/ 1 pessoa  
	@JoinColumn(name = "pessoa_id")
	private Pessoas pessoa;
	
	public Contato() {}

	public Contato(Long id, Integer tipoContato, Pessoas pessoa) {
		super();
		this.id = id;
		this.tipoContato = tipoContato;
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(Integer tipoContato) {
		this.tipoContato = tipoContato;
	}

	public Pessoas getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoas pessoa) {
		this.pessoa = pessoa;
	}
	
	public String toString() {
		return "Contato: " + "id: " + this.id + "Tipo de Contato: "
				+ this.tipoContato + "Pessoa: " + this.pessoa.getId();
	}
}
