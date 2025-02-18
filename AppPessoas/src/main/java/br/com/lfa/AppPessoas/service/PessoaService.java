package br.com.lfa.AppPessoas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lfa.AppPessoas.model.Pessoas;
import br.com.lfa.AppPessoas.repository.PessoasRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoasRepository pessoaRepository;
	
	//CRUD - Create
	public Pessoas save(Pessoas pessoa) {
		
		if(pessoa.getNome() == null) {
			System.out.println("Nome da pessoa vazio.");
			return null;
		}
		
		if(pessoa.getCep() == null) {
			System.out.println("CEP da pessoa vazio.");
			return null;
		}
		
		if(pessoa.getCidade() == null) {
			System.out.println("Cidade da pessoa vazia.");
			return null;
		}
		
		if(pessoa.getUf() == null) {
			System.out.println("UF da pessoa vazia.");
			return null;
		}
		try {
			return pessoaRepository.save(pessoa);
		}catch(Exception e) {
			System.out.println("Erro ao inserir pessoa: " + pessoa.toString() + 
					": " + e.getMessage());
			return null;
		}
	}
	
	//CRUD - Read
	public Optional<Pessoas> findById(Long id){
		return pessoaRepository.findById(id);
	}
	
	public List<Pessoas> findAll(){
		return pessoaRepository.findAll();
	}
	
	//CRUD - Update
	public Pessoas update(Pessoas pessoa) {
		Optional<Pessoas> findPessoa = pessoaRepository.findById(pessoa.getId());
		if(findPessoa.isPresent()) {
			Pessoas updPessoa = findPessoa.get();
			updPessoa.setNome(pessoa.getNome());
			updPessoa.setCep(pessoa.getCep());
			updPessoa.setCidade(pessoa.getCidade());
			updPessoa.setEndereco(pessoa.getEndereco());
			updPessoa.setUf(pessoa.getUf());
			return pessoaRepository.save(updPessoa);
		}
		return pessoaRepository.save(pessoa);
	}
	
	//CRUD - Delete
	public void delete(Long id) {
		pessoaRepository.deleteById(id);
	}
} 
