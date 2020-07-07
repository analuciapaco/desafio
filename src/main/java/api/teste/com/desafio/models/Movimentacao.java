package api.teste.com.desafio.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Organização: Desafio Teste
 * @author: Ana Lúcia Seles
 * @Versão da Classe = 1
 */

@Entity
@Table(name = "MOVIMENTACAO", catalog = "", schema = "public")
public class Movimentacao implements Serializable {
	@JsonProperty("id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@JsonProperty("conta")
	@JoinColumn(name = "id_conta", referencedColumnName = "id", nullable = true, foreignKey = @ForeignKey(name = "FK_CONTA"))
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Conta conta;
	
	
	@JsonProperty("tipo")
	@Column( nullable = false ) 
	private String tipo;
	
	
	@JsonProperty("responsavelTransacao")
	@Column( nullable = true ) 
	private String responsavelTransacao;
	
	@JsonProperty("numeroContaTransferencia")
	@Column( nullable = true ) 
	private String numeroContaTransferencia;
	
	@JsonProperty("data")
	@Column( nullable = true ) 
	private LocalDate data;
	
	
	@JsonProperty("valor")
	@Column( nullable = false ) 
	private BigDecimal valor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getResponsavelTransacao() {
		return responsavelTransacao;
	}

	public void setResponsavelTransacao(String responsavelTransacao) {
		this.responsavelTransacao = responsavelTransacao;
	}

	public String getNumeroContaTransferencia() {
		return numeroContaTransferencia;
	}

	public void setNumeroContaTransferencia(String numeroContaTransferencia) {
		this.numeroContaTransferencia = numeroContaTransferencia;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;

	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	

	}
