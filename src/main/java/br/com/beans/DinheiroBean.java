package br.com.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "dinheiroBean")
@SessionScoped
public class DinheiroBean {

	private double valor = 0;
	private int parcelas = 1;
	private double porcLucro = 0.25;
	private double valorParcela;
	private double valorLucro;
	private double custoFinal;

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getPorcLucro() {
		return porcLucro;
	}

	public void setPorcLucro(double porcLucro) {
		this.porcLucro = porcLucro;
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

	public double getValorLucro() {
		return valorLucro;
	}

	public void setValorLucro(double valorLucro) {
		this.valorLucro = valorLucro;
	}

	public double getCustoFinal() {
		return custoFinal;
	}

	public void setCustoFinal(double custoFinal) {
		this.custoFinal = custoFinal;
	}

	public double calculaCustoFinal() {
		double custoFinal = this.valor * (Math.pow((1 + this.porcLucro), this.parcelas));
		return custoFinal;
	}

	public double calculaValorParcela() {
		return this.calculaCustoFinal() / this.parcelas;
	}

	public double calculaValorLucro() {
		return this.calculaCustoFinal() - this.valor;
	}

	public void calcula() {
		this.custoFinal = this.calculaCustoFinal();
		this.valorParcela = this.calculaValorParcela();
		this.valorLucro = this.calculaValorLucro();
	}

}
