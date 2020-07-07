/**
 * @Organização: Desafio Teste
 * @author: Ana Lúcia Seles
  *@Versão da Classe = 1
 */

package api.teste.com.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.teste.com.desafio.models.Conta;
import api.teste.com.desafio.models.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

	Movimentacao findById(long id);
	Movimentacao findByConta(Conta conta);

}
