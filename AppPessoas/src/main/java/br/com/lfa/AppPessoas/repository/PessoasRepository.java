package br.com.lfa.AppPessoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lfa.AppPessoas.model.Pessoas;

@Repository
public interface PessoasRepository extends JpaRepository<Pessoas, Long> {

}
