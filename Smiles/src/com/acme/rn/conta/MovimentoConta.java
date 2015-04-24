package com.acme.rn.conta;
import java.util.*;

public class MovimentoConta {
	ContaMilhagem contaMilhagemdeOrigem, contaMilhagemdeDestino;
	int valorTransacao, tipodaTransacao;
	public String nomedaFonte;
	public Date date;

	public String getNomeExtrato() {
		String nomeT = this.contaMilhagemdeOrigem.cliente.nome;
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
		switch (contaMilhagemdeOrigem.cliente.sexo) {
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
				+ " \n" + "Nome da fonte: " + this.nomedaFonte + " \n"
				+ "Valor: " + this.valorTransacao + " \n"
				+ "Conta de destino: " + this.contaMilhagemdeDestino + " \n"
				+ "Data: " + this.date;
		return res;
	}

	public MovimentoConta(ContaMilhagem origem, int valor,
			ContaMilhagem destino, String nomedaFonte, Date date) {
		this.contaMilhagemdeOrigem = origem;
		this.valorTransacao = valor;
		this.contaMilhagemdeDestino = destino;
		this.nomedaFonte = nomedaFonte;
		this.date = date;
	}
}
