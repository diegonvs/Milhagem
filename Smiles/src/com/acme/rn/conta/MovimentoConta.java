package com.acme.rn.conta;

import java.util.Date;

import com.acme.rn.classesGerais.Registro;

public abstract class MovimentoConta extends Registro {
	// Atributos:
	ContaMilhagem contaMilhagemdeOrigem;
	private int valorTransacao; // tipodaTransacao;
	private String nomedaFonte;
	public Date date;

	/*
	 * public static int TIPO_CREDITO = 1, TIPO_DEBITO = 2, TIPO_TRANSFERENCIA =
	 * 3;
	 */
	/*
	 * Construtores
	 * 
	 * public MovimentoConta(ContaMilhagem cm, int valor) {
	 * this.setValorTransacao(valor); this.contaMilhagemdeOrigem = cm;
	 * this.setNomedaFonte("Banco Cr√©dito ou D√©bito"); this.date = new Date();
	 * }
	 */

	// MÈtodos
	public String getPrimeiroNome() {
		String nomeT = this.contaMilhagemdeOrigem.getCliente().getNome();
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
		String nomeT = this.contaMilhagemdeOrigem.getCliente().getNome();
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
		String nome = null;
		switch (contaMilhagemdeOrigem.getCliente().getSexo()) {
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
				+ "Valor: " + this.getValorTransacao() + " \n" + "Data: "
				+ this.date;
		return res;
	}

	public int getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(int valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	/*
	 * public int getTipodaTransacao() { return tipodaTransacao; }
	 * 
	 * public void setTipodaTransacao(int tipodaTransacao) {
	 * this.tipodaTransacao = tipodaTransacao; }
	 */

	public String getNomedaFonte() {
		return nomedaFonte;
	}

	public void setNomedaFonte(String nomedaFonte) {
		this.nomedaFonte = nomedaFonte;
	}

	public String getChave() {
		return Long.toString(this.contaMilhagemdeOrigem.getIdentificadorconta()
				.getNumero());
	}
	
	@Override
	public void validar() {
		if(this.contaMilhagemdeOrigem.equals(null)){
			System.err.println("Conta Milhagem n„o pode ser null");
		}
		if(this.valorTransacao <= 0){
			System.err.println("Valor n„o pode ser menor ou igual a zero!");
		}
		if(this.nomedaFonte.length() > 100){
			System.err.println("N„o pode conter mais que 100 caracteres.");
		}
		if(this.date.equals(null)){
			System.err.println("Date n„o pode ser null");
		}
	}
}
