/**
 * @Organização: Desafio Teste
 * @author: Ana Lúcia Seles
  *@Versão da Classe = 1
 */

package api.teste.com.desafio.resources;

import java.math.BigDecimal;
import java.util.List;

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

import api.teste.com.desafio.models.Movimentacao;
import api.teste.com.desafio.repository.MovimentacaoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST MOVIMENTACAO")
@CrossOrigin(origins = "*")
public class MovimentacaoResource {
	@Autowired
	MovimentacaoRepository movimentacaoRepository;

	@GetMapping("/movimentacao")
	@ApiOperation(value = "Retorna uma lista de Movimentacao Corrente")
	public List<Movimentacao> listaMovimentacaos() {
		return movimentacaoRepository.findAll();
	}

	@GetMapping("/movimentacao/{id}")
	@ApiOperation(value = "Retorna uma movimentacao específica")
	public Movimentacao listaMovimentacao(@PathVariable(value = "id") long id) {
		return movimentacaoRepository.findById(id);
	}
	
	@PostMapping("/movimentacao")
	@ApiOperation(value = "Salva uma movimentacao")
	public ResponseEntity salvarMovimentacao(@RequestBody Movimentacao movimentacao) {
		try {
		movimentacaoRepository.save(movimentacao);
        return ResponseEntity.status(200).build();
		
		}catch(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/movimentacao")
	@ApiOperation(value = "Apaga uma movimentacao específica")
	public void deletarMovimentacao(@RequestBody Movimentacao movimentacao) {
		movimentacaoRepository.delete(movimentacao);
	}

	@PutMapping("/movimentacao")
	@ApiOperation(value = "Altera uma movimentacao específica")
	public Movimentacao alterarMovimentacao(@RequestBody Movimentacao movimentacao) {
		return movimentacaoRepository.save(movimentacao);
	}

	@PutMapping("/movimentacao/deposito")
	@ApiOperation(value = "Deposita uma movimentacao específica")
	public Movimentacao depositarEmMovimentacao(@RequestBody Movimentacao movimentacao,BigDecimal deposito) {
		return movimentacaoRepository.save(movimentacao);
	}

}
