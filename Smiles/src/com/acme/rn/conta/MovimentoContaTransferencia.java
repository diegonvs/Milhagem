package com.acme.rn.conta;

import java.util.Date;

public class MovimentoContaTransferencia extends MovimentoConta {
	// Atributos
	public ContaMilhagem contaOrigem;
	public ContaMilhagem contaDestino;
	private int valor;
	public Date date;

	// Getters and Setters
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	// Construtor
	public MovimentoContaTransferencia(ContaMilhagem contaOrigem, int valor,
			ContaMilhagem contaDestino) {
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.setValor(valor);
		this.setValorTransacao(valor);
		this.date = new Date();
		this.contaOrigem = contaOrigem;
	}
}
