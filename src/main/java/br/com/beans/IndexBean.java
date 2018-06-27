package br.com.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "indexBean")
public class IndexBean {
	private String formaDePagamento = "Dinheiro";
	private boolean opcDinheiro = false, opcCartao = false;

	public void atualiza() {
		if (this.formaDePagamento.equals("Dinheiro")) {
			opcDinheiro = true;
			opcCartao = false;
		} else if (this.formaDePagamento.equals("Cartão")) {
			opcDinheiro = false;
			opcCartao = true;
		}

	}

	public boolean isOpcCartao() {
		return opcCartao;
	}

	public void setOpcCartao(boolean opcCartao) {
		this.opcCartao = opcCartao;
	}

	public boolean isOpcDinheiro() {
		return opcDinheiro;
	}

	public void setOpcDinheiro(boolean opcDinheiro) {
		this.opcDinheiro = opcDinheiro;
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

}
