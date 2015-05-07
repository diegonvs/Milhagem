package com.acme.rn.conta;
import java.util.*;

public class MovimentoConta {
	ContaMilhagem contaMilhagemdeOrigem, contaMilhagemdeDestino;
	private int valorTransacao, tipodaTransacao;
	private String nomedaFonte;
	public Date date;
	public static int TIPO_CREDITO=1,TIPO_DEBITO=2,TIPO_TRANSFERENCIA=3;

	public String getNomeExtrato() {
		String nomeT = this.contaMilhagemdeOrigem.cliente.getNome();
		String primeiroNome;
		String ultimoNome;
		if (nomeT.indexOf(' ') != -1) {
			primeiroNome = (nomeT.substring(0, nomeT.indexOf(' ')))
					.toUpperCase();
		} else
			primeiroNome = nomeT;
		if (nomeT.indexOf(' ') == -1) {
			ultimoNome = null;
		} else {
			ultimoNome = nomeT
					.substring(nomeT.lastIndexOf(' '), nomeT.length())
					.toUpperCase();
		}
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

	public MovimentoConta(ContaMilhagem origem, int valor,
			ContaMilhagem destino, String nomedaFonte, Date date) {
		this.contaMilhagemdeOrigem = origem;
		this.setValorTransacao(valor);
		this.contaMilhagemdeDestino = destino;
		this.setNomedaFonte(nomedaFonte);
		this.date = date;
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
