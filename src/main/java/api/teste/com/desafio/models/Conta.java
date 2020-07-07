package api.teste.com.desafio.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Organização: Desafio Teste
 * @author: Ana Lúcia Seles
 * @Versão da Classe = 1
 */

@Entity
@Table(name = "CONTA", catalog = "", schema = "public")
public class Conta implements Serializable {
	@JsonProperty("id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@JsonProperty("numero")
	@Column( nullable = false ) 
	private String numero;
	
	
	@JsonProperty("responsavel")
	@Column( nullable = false ) 
	private String responsavel;
	
	
	@JsonProperty("saldo")
	@Column( nullable = false ) 
	private BigDecimal saldo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	
	
	
}
