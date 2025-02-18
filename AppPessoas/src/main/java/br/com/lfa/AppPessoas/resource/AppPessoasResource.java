package br.com.lfa.AppPessoas.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lfa.AppPessoas.model.Pessoas;
import br.com.lfa.AppPessoas.repository.PessoasRepository;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api") //https://localhost:8080/api
public class AppPessoasResource {
	
	@Autowired
	private PessoasRepository pessoasRepository;
	
	@Operation(summary = "Lista pessoas.")
	@GetMapping("lista") //https://localhost:8080/api/lista
	public List<Pessoas> listar(){
		List<Pessoas> listPessoas = pessoasRepository.findAll();
		return listPessoas;
	}
	
	@Operation(summary = "Verifica se a API está funcionando.")
	@GetMapping
	public String getApi() {
		return "Api java funcionando!";
	}
	
	@Operation(summary = "Adiciona informações a uma pessoa.")
	@GetMapping("getPessoa") //https://localhost:8080/api/getPessoa
	public Pessoas getPessoa() {
		Pessoas pessoa = new Pessoas();
		pessoa.setNome("Luan");
		pessoa.setEndereco("Mogi das Cruzes");
		pessoa.setCep("08820290");
		pessoa.setCidade("Mogi");
		pessoa.setUf("Sp");
		
		System.out.println(pessoa);
		
		return pessoa;
	}
	
	@Operation(summary = "Lista informações da pessoa.")
	@GetMapping("getPessoas") //https://localhost:8080/api/getPessoas
	public List<Pessoas> getPessoas(){
		List<Pessoas> listPessoas = new ArrayList<Pessoas>();
		
		Pessoas pessoa1 = new Pessoas();
		pessoa1.setNome("Luan");
		pessoa1.setEndereco("Mogi");
		pessoa1.setCep("08820290");
		pessoa1.setCidade("Mogi das Cruzes");
		pessoa1.setUf("Sp");		
		listPessoas.add(pessoa1);		
		
		Pessoas pessoa2 = new Pessoas();
		pessoa2.setNome("Lucas");
		pessoa2.setEndereco("Rua Suzano");
		pessoa2.setCep("08829890");
		pessoa2.setCidade("Suzano");
		pessoa2.setUf("SP");		
		listPessoas.add(pessoa2);	
		
		Pessoas pessoa3 = new Pessoas();
		pessoa3.setNome("Cláudio");
		pessoa3.setEndereco("Ferraz");
		pessoa3.setCep("07629890");
		pessoa3.setCidade("Ferraz de Vasconcelos");
		pessoa3.setUf("SP");		
		listPessoas.add(pessoa3);	
		
		return listPessoas;
		
	}
	
	

}
