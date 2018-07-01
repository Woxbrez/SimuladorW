package br.com.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_simulacoes")
public class Simulacoes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "simu_codigo")
	private Long codigo;

	@Column(name = "simu_valor")
	private double valor;
	
	@Column(name = "simu_parcelas")
	private int parcelas;
	
	@Column(name = "simu_valorparcela")
	private double valorParcela;
	
	@Column(name = "simu_custofinal")
	private double custoFinal;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public double getCustoFinal() {
		return custoFinal;
	}

	public void setCustoFinal(double custoFinal) {
		this.custoFinal = custoFinal;
	}

}
