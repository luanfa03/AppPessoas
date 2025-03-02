package br.com.lfa.AppPessoas.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lfa.AppPessoas.dto.MalaDiretaDTO;
import br.com.lfa.AppPessoas.model.Pessoas;
import br.com.lfa.AppPessoas.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/pessoas") //http://localhost:8080/api/pessoas
public class PessoaResource {
	
	@Autowired
	PessoaService pessoaService;
	
	@Operation(summary = "Salvar Pessoa", description = "Adiciona uma nova pessoa e a armazena no banco de dados.")
	@PostMapping //POST http://localhost:8080/api/pessoas
	public ResponseEntity<Pessoas> save(@RequestBody Pessoas pessoa) {
		Pessoas newPessoa = pessoaService.save(pessoa);
		if(newPessoa == null) {
			return ResponseEntity.notFound().build(); //status code 404
		}else {
			return ResponseEntity.ok(newPessoa); // status code 200
		}
	}
	
	@Operation(summary = "Procura Pessoa por id", description = "Procura e exibe a pessoa pelo id solicitado.")
	@GetMapping("/{id}") //GET http://localhost:8080/api/pessoas/1
	public ResponseEntity<Optional<Pessoas>> findById(@PathVariable Long id){
		Optional<Pessoas> pessoa = pessoaService.findById(id);
		if(pessoa.isEmpty()) {
			return ResponseEntity.notFound().build(); //status code 404
		}else {
			return ResponseEntity.ok(pessoa); //status code 200
		}
	}	
	
	@Operation(summary = "Procura Pessoa por id e exibe a mala direta", description = "Procura e exibe a pessoa pelo id solicitado, porém concatena o endereço pela mala direta.")
	@GetMapping("/maladireta/{id}")//GET http://localhost:8080/api/pessoas/maladireta/1
    public ResponseEntity<MalaDiretaDTO> buscarPorMalaDireta(@PathVariable Long id) {
        try {
            Optional<Pessoas> pessoaMd = pessoaService.findById(id);

            if (pessoaMd.isPresent()) {
                Pessoas pessoa = pessoaMd.get();
                String malaDireta = String.format("%s – CEP: %s – %s/%s",
                        pessoa.getEndereco(),
                        pessoa.getCep(),
                        pessoa.getCidade(),
                        pessoa.getUf());

                MalaDiretaDTO dto = new MalaDiretaDTO(pessoa.getId(), pessoa.getNome(), malaDireta);
                return ResponseEntity.ok(dto);
            }

            return ResponseEntity.notFound().build();
        } catch (Exception e) {
        	return ResponseEntity.notFound().build(); //status code 404
        }
    }
	
	@Operation(summary = "Exibe todas as pessoas cadastradas", description = "Procura e exibe todas as pessoas cadastradas no banco de dados.")
	@GetMapping //GET http://localhost:8080/api/pessoas
	public ResponseEntity<List<Pessoas>> findAll(){
		List<Pessoas> pessoas = pessoaService.findAll();
		if(pessoas == null)
			return ResponseEntity.notFound().build();
		if(pessoas.size() == 0)	
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(pessoas);
	}
	
	@Operation(summary = "Atualizar Pessoa", description = "Atualiza informações de uma pessoa já cadastrada.")
	@CrossOrigin(origins = "http://localhost:4200") // Isso permite requisições de qualquer método HTTP
	@PutMapping("/{id}") //PUT http://localhost:8080/api/pessoas/1
	public ResponseEntity<Pessoas> update(@PathVariable Long id, @RequestBody Pessoas pessoa) {
	    Optional<Pessoas> findPessoa = pessoaService.findById(id);
	    if (findPessoa.isPresent()) {
	        Pessoas updPessoa = findPessoa.get();
	        updPessoa.setNome(pessoa.getNome());
	        updPessoa.setCep(pessoa.getCep());
	        updPessoa.setCidade(pessoa.getCidade());
	        updPessoa.setEndereco(pessoa.getEndereco());
	        updPessoa.setUf(pessoa.getUf());
	        return ResponseEntity.ok(pessoaService.save(updPessoa));
	    }
	    return ResponseEntity.notFound().build();
	}
	
	@Operation(summary = "Deletar Pessoa", description = "Exclui informações de uma pessoa já cadastrada")
	@DeleteMapping("/{id}") //DELETE http://localhost:8080/api/pessoas/1
	public ResponseEntity<?> delete(@PathVariable Long id){
		pessoaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); //status code 204
	}
} 
