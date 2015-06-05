package com.acme.rn.conta;

import java.util.Date;

public class MovimentoContaCredito extends MovimentoConta {
	// Atributos
	public ContaMilhagem cm;
	private int valor;
	public Date date;

	// Getters and Setters
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	// toString
	public String toString() {
		String s = "Movimento de Crédito" + "na conta" + this.cm.toString()
				+ "\n" + "No valor de: " + this.getValor() + "Data: " + this.date;
		return s;
	}

	// Construtor
	public MovimentoContaCredito(ContaMilhagem cm, int valor) {
		this.cm = cm;
		this.setNomedaFonte(cm.getCliente().getNome());
		this.setValorTransacao(valor);
		this.setValor(valor);
		this.date = new Date();
	}

}
