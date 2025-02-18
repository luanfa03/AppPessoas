package br.com.lfa.AppPessoas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lfa.AppPessoas.model.Contato;
import br.com.lfa.AppPessoas.model.Pessoas;
import br.com.lfa.AppPessoas.repository.ContatoRepository;
import br.com.lfa.AppPessoas.repository.PessoasRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private PessoasRepository pessoaRepository;
	
	public Contato save(Contato contato) {
		if(contato.getPessoa().getId() != null) {
			Optional<Pessoas> findPessoa = pessoaRepository.findById(contato.getPessoa().getId());
			if(findPessoa.isEmpty()) {
				System.out.println("Pessoa não encontrada!");
				return null;
			}else {
				contato.setPessoa(findPessoa.get());
				return contatoRepository.save(contato);
			}
		}else {
			System.out.println("Pessoa não existe!");
			return null;
		}
	}
	
	public Optional<Contato> findById(Long id){
		return contatoRepository.findById(id);
	}
	
	public List<Contato> listByPessoaId(Long pessoaId) {
        return contatoRepository.findByPessoaId(pessoaId);
    }
	
	public Contato update(Long id, Contato contato) {
		Optional<Contato> findContato = contatoRepository.findById(contato.getId());
		if(findContato.isPresent()) {
			Contato updContato = findContato.get();
			updContato.setTipoContato(contato.getTipoContato());
			return contatoRepository.save(updContato);
		}
		return contatoRepository.save(contato);
	}
	
	public void delete(Long id) {
		contatoRepository.deleteById(id);
	}
}
