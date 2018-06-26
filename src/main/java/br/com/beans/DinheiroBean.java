package br.com.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "dinheiroBean")
@SessionScoped
public class DinheiroBean {

	private double valor = 0;
	private int parcelas = 1;
	private double porcLucro = 0.25;

	public double custoFinal() {
		double cf = this.valor * (parcelas * porcLucro);
		cf = cf + this.valor;
		return cf;
	}
	
	public double valorParcela(double custoFinal) {
		return custoFinal/this.parcelas;
	}
	
	public double lucro() {
		return this.custoFinal() - this.valor;
	}

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

}
