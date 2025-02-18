package br.com.lfa.AppPessoas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lfa.AppPessoas.model.Contato;
import br.com.lfa.AppPessoas.model.Pessoas;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{
	List<Contato> findByPessoaId(Long pessoaId);
}
