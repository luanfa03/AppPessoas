package br.com.lfa.AppPessoas.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lfa.AppPessoas.model.Contato;
import br.com.lfa.AppPessoas.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/contato") //http:localhost:8080/api/contato
public class ContatoResource {
	
	@Autowired
	private ContatoService contatoService;
	
	@Operation(summary = "Salvar Contato", description = "Salva contato e o adiciona a uma pessoa existente no banco de dados.")
	@PostMapping //POST http://localhost:8080/api/contato
	public ResponseEntity<Contato> save(@RequestBody Contato contato) {
		Contato newContato = contatoService.save(contato);
		if(newContato == null) {
			return ResponseEntity.notFound().build(); //status code 404
		}else {
			return ResponseEntity.ok(newContato); // status code 200
		}
	}
	
	@Operation(summary = "Exibe Contato por id", description = "Procura e exibe o contato de uma pessoa pelo id do contato.")
	@GetMapping("/{id}")//GET http://localhost:8080/api/contato/1
	public ResponseEntity<Optional<Contato>> findById(@PathVariable Long id){
		Optional<Contato> findContato = contatoService.findById(id);
		if(findContato == null) {
			return ResponseEntity.notFound().build(); //status code 404
		}else {
			return ResponseEntity.ok(findContato); // status code 200
		}
	}
	
	@Operation(summary = "Exibe Contato por id da pessoa", description = "Procura e exibe o contato de uma pessoa pelo id da pessoa.")
	@GetMapping("/pessoa/{pessoaId}")//GET http://localhost:8080/api/contato/pessoa/1
    public ResponseEntity<List<Contato>> listByPessoaId(@PathVariable Long pessoaId) {
		try {
            List<Contato> contato = contatoService.listByPessoaId(pessoaId);
            return ResponseEntity.ok(contato); // status code 200
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); //status code 404
        }
	}
	
	@Operation(summary = "Atualizar Contato", description = "Atualiza o contato de uma pessoa já cadastrada.")
	@PutMapping("/{id}") //PUT http:localhost:8080/api/contato
	public ResponseEntity<Contato> update(@PathVariable Long id, @RequestBody Contato contato){
		Contato updContato = contatoService.update(id, contato);
		if(updContato == null) {
			return ResponseEntity.notFound().build(); //status code 404
		}else {
			return ResponseEntity.ok(updContato); // status code 200
		}
	}
	
	@Operation(summary = "Deletar Contato", description = "Exclui o contato de uma pessoa já cadastrada.")
	@DeleteMapping("/{id}") //DELETE http://localhost:8080/api/contato/1
	public ResponseEntity<?> delete(@PathVariable Long id){
		contatoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // status code 204
	}
}