/**
 * @Organização: Desafio Teste
 * @author: Ana Lúcia Seles
  *@Versão da Classe = 1
 */

package api.teste.com.desafio.resources;

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

import api.teste.com.desafio.models.Conta;
import api.teste.com.desafio.repository.ContaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST CONTA CORRENTE")
@CrossOrigin(origins = "*")
public class ContaResource {
	@Autowired
	ContaRepository contaRepository;

	@GetMapping("/contas")
	@ApiOperation(value = "Retorna uma lista de Contas Corrente")
	public List<Conta> listaContas() {
		return contaRepository.findAll();
	}

	@GetMapping("/conta/{id}")
	@ApiOperation(value = "Retorna uma conta específica")
	public Conta listaConta(@PathVariable(value = "id") long id) {
		return contaRepository.findById(id);
	}

	@GetMapping("/conta/numero/{numero}")
	@ApiOperation(value = "Retorna uma conta por número de conta")
	public Conta listaConta(@PathVariable(value = "numero") String numero) {
		return contaRepository.findByNumero(numero);
	}
	
	@PostMapping("/conta")
	@ApiOperation(value = "Salva uma conta")
	public ResponseEntity salvarConta(@RequestBody Conta conta) {
		try {
		if(conta.getResponsavel()!=null && conta.getNumero()!=null && conta.getSaldo()!=null) {	
		contaRepository.save(conta);
        return ResponseEntity.status(200).build();
		}

		}catch(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.status(400).build();
	}
	
	@DeleteMapping("/conta")
	@ApiOperation(value = "Apaga uma conta específica")
	public void deletarConta(@RequestBody Conta conta) {
		contaRepository.delete(conta);
	}

	@PutMapping("/conta")
	@ApiOperation(value = "Altera uma conta específica")
	public Conta alterarConta(@RequestBody Conta conta) {
		return contaRepository.save(conta);
	}

	@PutMapping("/conta/deposito")
	@ApiOperation(value = "Deposita uma conta específica")
	public Conta depositarEmConta(@RequestBody Conta conta,BigDecimal deposito) {
		return contaRepository.save(conta);
	}

}
