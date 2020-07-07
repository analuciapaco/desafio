/**
 * @Organização: Desafio Teste
 * @author: Ana Lúcia Seles
  *@Versão da Classe = 1
 */

package api.teste.com.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.teste.com.desafio.models.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

	Conta findById(long id);
	Conta findByNumero(String numero);

}
