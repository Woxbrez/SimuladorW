package br.com.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "creditoBean")
@SessionScoped
public class CreditoBean {

	private double valor = 0;
	private int parcelas = 1;
	private double porcLucro = 0.1;
	private double[] taxaIntermediacao = new double[] { 0.07, 0.0499, 0.0559 };
	private double[] taxaParcelamento = new double[] { 0, 0, 0.0409, 0.0541, 0.0670, 0.0796, 0.0920, 0.1041, 0.1161,
			0.1278, 0.1392, 0.1505, 0.1615 };

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double retornaValorVenda() {
		double valorVenda;
		valorVenda = this.valor + (this.valor * this.porcLucro) + (this.valor * this.taxaIntermediacao[0]);
		return valorVenda;
	}

	public double valorDescontado() {
		double valorDescontado;
		if (this.parcelas > 2) {
			valorDescontado = (this.valor * this.taxaIntermediacao[2]);
		} else {
			valorDescontado = (this.valor * this.taxaIntermediacao[this.parcelas]);
		}
		return valorDescontado;
	}

	public double valorLucro() {
		double lucro = this.retornaValorVenda() - this.valorDescontado() - this.valor;
		return lucro;
	}

	public double retornaCustoFinal() {
		double custoFinal;
		custoFinal = this.retornaValorVenda() * this.taxaParcelamento[this.parcelas];
		custoFinal = this.retornaValorVenda() + custoFinal;
		return custoFinal;
	}

	public double valorParcela() {
		double valorParcela;
		valorParcela = this.retornaCustoFinal() / this.parcelas;
		return valorParcela;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public double getPorcLucro() {
		return porcLucro;
	}

	public void setPorcLucro(double porcLucro) {
		this.porcLucro = porcLucro;
	}

	public double[] getTaxaIntermediacao() {
		return taxaIntermediacao;
	}

	public void setTaxaIntermediacao(double[] taxaIntermediacao) {
		this.taxaIntermediacao = taxaIntermediacao;
	}

	public double[] getTaxaParcelamento() {
		return taxaParcelamento;
	}

	public void setTaxaParcelamento(double[] taxaParcelamento) {
		this.taxaParcelamento = taxaParcelamento;
	}

}
