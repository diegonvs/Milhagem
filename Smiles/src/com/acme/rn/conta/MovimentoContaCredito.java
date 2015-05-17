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
		String s = "Movimento de Cr�dito" + "na conta" + this.cm.toString()
				+ "\n" + "No valor de: " + this.getValor() + "Data: " + this.date;
		return s;
	}

	// Construtor
	public MovimentoContaCredito(ContaMilhagem cm, int valor) {
		super(cm, valor);
		this.date = new Date();
	}

}
