package com.acme.rn.conta;

import java.util.*;

public class MovimentoConta {
	ContaMilhagem contaMilhagemdeOrigem, contaMilhagemdeDestino;
	private int valorTransacao, tipodaTransacao;
	private String nomedaFonte;
	public Date date;
	public static int TIPO_CREDITO = 1, TIPO_DEBITO = 2,
			TIPO_TRANSFERENCIA = 3;

	public MovimentoConta(ContaMilhagem origem, int valor,
			ContaMilhagem destino, String nomedaFonte, Date date) {
		this.contaMilhagemdeOrigem = origem;
		this.setValorTransacao(valor);
		this.contaMilhagemdeDestino = destino;
		this.setNomedaFonte(nomedaFonte);
		this.date = date;
	}
	
	public MovimentoConta(ContaMilhagem cm, int valor, Date date) {
		this.setValorTransacao(valor);
		this.contaMilhagemdeDestino = cm;
		this.setNomedaFonte("Banco Crédito ou Débito");
		this.date = date;
	}

	public String getPrimeiroNome() {
		String nomeT = this.contaMilhagemdeOrigem.cliente.getNome();
		String primeiroNome;
		if (nomeT.indexOf(' ') != -1) {
			primeiroNome = (nomeT.substring(0, nomeT.indexOf(' ')))
					.toUpperCase();
		} else {
			primeiroNome = nomeT;
		}
		return primeiroNome;
	}

	public String getUltimoNome() {
		String nomeT = this.contaMilhagemdeOrigem.cliente.getNome();
		String ultimoNome;
		if (nomeT.indexOf(' ') == -1) {
			ultimoNome = null;
		} else {
			ultimoNome = nomeT
					.substring(nomeT.lastIndexOf(' '), nomeT.length())
					.toUpperCase();
		}
		return ultimoNome;
	}

	public String getNomeExtrato() {
		// String nomeT = this.contaMilhagemdeOrigem.cliente.getNome();
		String primeiroNome;
		String ultimoNome;
		primeiroNome = this.getPrimeiroNome();
		ultimoNome = this.getUltimoNome();

		/*
		 * if (nomeT.indexOf(' ') != -1) { primeiroNome = (nomeT.substring(0,
		 * nomeT.indexOf(' '))) .toUpperCase(); } else primeiroNome = nomeT; if
		 * (nomeT.indexOf(' ') == -1) { ultimoNome = null; } else { ultimoNome =
		 * nomeT .substring(nomeT.lastIndexOf(' '), nomeT.length())
		 * .toUpperCase(); }
		 */
		String nome = null;
		switch (contaMilhagemdeOrigem.cliente.getSexo()) {
		case 0:
			nome = ultimoNome + ',' + primeiroNome + " MR.";
			break;
		case 1:
			nome = ultimoNome + ',' + primeiroNome + " MRS.";
			break;
		default:
			return null;
		}
		return nome;

	}

	public String toString() {
		String res = "\n" + "Conta de origem: " + this.contaMilhagemdeOrigem
				+ " \n" + "Nome da fonte: " + this.getNomedaFonte() + " \n"
				+ "Valor: " + this.getValorTransacao() + " \n"
				+ "Conta de destino: " + this.contaMilhagemdeDestino + " \n"
				+ "Data: " + this.date;
		return res;
	}

	public int getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(int valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	public int getTipodaTransacao() {
		return tipodaTransacao;
	}

	public void setTipodaTransacao(int tipodaTransacao) {
		this.tipodaTransacao = tipodaTransacao;
	}

	public String getNomedaFonte() {
		return nomedaFonte;
	}

	public void setNomedaFonte(String nomedaFonte) {
		this.nomedaFonte = nomedaFonte;
	}
}
