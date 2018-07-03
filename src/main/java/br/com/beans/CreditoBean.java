package br.com.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.crud.ImplementacaoCrud;
import br.com.entidades.Simulacoes;

@ManagedBean(name = "creditoBean")
@SessionScoped
public class CreditoBean {

	private double valor;
	private int parcelas;
	private double porcLucro = 0.1;
	private double custoFinal;
	private double valorParcela;
	private double valorLucro;
	private double valorVenda;
	private double valorDescontado;
	private double[] taxaIntermediacao = new double[] { 0.07, 0.0499, 0.0559 };
	private double[] taxaParcelamento = new double[] { 0, 0, 0.0451, 0.0604, 0.0759, 0.0915, 0.1072, 0.1231, 0.1392,
			0.1554, 0.1717, 0.1882, 0.2048 };
	private Simulacoes s = new Simulacoes();
	ImplementacaoCrud<Simulacoes> c = new ImplementacaoCrud<Simulacoes>();
	
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

	public double getCustoFinal() {
		return custoFinal;
	}

	public void setCustoFinal(double custoFinal) {
		this.custoFinal = custoFinal;
	}

	public double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public double getValorLucro() {
		return valorLucro;
	}

	public void setValorLucro(double valorLucro) {
		this.valorLucro = valorLucro;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public double getValorDescontado() {
		return valorDescontado;
	}

	public void setValorDescontado(double valorDescontado) {
		this.valorDescontado = valorDescontado;
	}

	public double calculaValorDescontado() {
		double valorDescontado;
		if (this.parcelas > 2) {
			valorDescontado = (this.valorVenda * this.taxaIntermediacao[2]);
		} else {
			valorDescontado = (this.valorVenda * this.taxaIntermediacao[this.parcelas]);
		}
		return valorDescontado;
	}

	public double calculaValorVenda() {
		return (this.valor + (this.valor * this.porcLucro) + (this.valor * this.taxaIntermediacao[0]));
	}

	public double calculaCustoFinal() {
		double custoFinal = this.valorVenda * (this.taxaParcelamento[this.parcelas]);
		custoFinal = this.valorVenda + custoFinal;
		return custoFinal;
	}

	public double calculaValorParcela() {
		return (this.calculaCustoFinal() / this.parcelas);
	}

	public double calculaValorLucro() {
		return (this.valorVenda - this.valorDescontado - this.valor);
	}
	
	public void salva() throws Exception {
		s.setValor(this.valor);
		s.setParcelas(this.parcelas);
		s.setCustoFinal(this.custoFinal);
		s.setValorParcela(this.valorParcela);
		c.save(s);
		s = new Simulacoes();
	}

	public void calcula() throws Exception {
		this.valorVenda = this.calculaValorVenda();
		this.custoFinal = this.calculaCustoFinal();
		this.valorParcela = this.calculaValorParcela();
		this.valorDescontado = this.calculaValorDescontado();
		this.valorLucro = this.calculaValorLucro();	
	}

}
