package com.acme.rn.conta;

import java.util.Date;

public class MovimentoContaDebito extends MovimentoConta {
	// Atributos
	ContaMilhagem contaMilhagem;
	private int valorTransacao;
	private String nomedaFonte;
	public Date date;

	// Construtor
	public MovimentoContaDebito(ContaMilhagem destino, int valor,
			String nomedaFonte) {
		super(destino, valor);
		this.setNomedaFonte(nomedaFonte);
		this.date = new Date();
	}

	// toString
	public String toString() {
		String s = "Movimento de Crédito" + "na conta"
				+ this.contaMilhagem.toString() + "\n" + "No valor de: "
				+ this.getValorTransacao() + "\n" + this.date;
		return s;
	}

	// Getters and Setters:
	public ContaMilhagem getContaMilhagemdeOrigem() {
		return contaMilhagemdeOrigem;
	}

	public void setContaMilhagemdeOrigem(ContaMilhagem contaMilhagemdeOrigem) {
		this.contaMilhagemdeOrigem = contaMilhagemdeOrigem;
	}

	public int getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(int valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	public String getNomedaFonte() {
		return nomedaFonte;
	}

	public void setNomedaFonte(String nomedaFonte) {
		this.nomedaFonte = nomedaFonte;
	}

}
