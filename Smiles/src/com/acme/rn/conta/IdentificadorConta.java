package com.acme.rn.conta;

import java.util.Scanner;

public class IdentificadorConta {
	private long numero;

	public int calcularDigitoVerificador(long numero) {
		int soma = 0;
		String numeroS = Long.toString(numero);
		for (int i = 0; i < numeroS.length(); i++) {
			soma = soma + numeroS.charAt(i) - 48;
		}
		return soma % 99;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public boolean verificarValidadeDigito(int num) {
		if (calcularDigitoVerificador(this.numero) == num) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString(){
		String n = "Identificador: "+ this.numero;
		return n;
	}
	public static IdentificadorConta criarObjeto(Scanner s) {
		long n;
		System.out.print("Informe o número identificador da conta: ");
		n = s.nextLong();
		IdentificadorConta ic = new IdentificadorConta(n);
		return ic;
	}
	public IdentificadorConta(long numero) {
		this.numero = numero;
	}
}
