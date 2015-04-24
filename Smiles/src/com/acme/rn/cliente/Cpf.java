package com.acme.rn.cliente;
import java.util.Scanner;

public class Cpf {

	private int numero;
	private int digito;

	public Cpf(int numero, int digito) {
		//Construtor que recebe dois inteiros
		this.setNumero(numero);
		this.setDigito(digito);
	}

	public Cpf(String cpf) {
		//Construtor sobrescrito que recebe uma String
		int numero = Integer.parseInt(cpf.substring(0, 9));
		int dig = Integer.parseInt(cpf.substring(9, 11));
		this.setNumero(numero);
		this.setDigito(dig);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		if (numero > 0 && numero <= 999999999) {
			this.numero = numero;
		} else {
			System.err.println("Numero do cpf invalido!");
		}
	}

	public int getDigito() {
		return digito;
	}

	public void setDigito(int digito) {
		if (digito >= 0 && digito <= 99) {
			this.digito = digito;
		} else {
			System.err.println("Digito do cpf invalido!");
		}
	}
	
	public String getCpf(){
		String n1 = Integer.toString(this.numero);
		String n2 = Integer.toString(this.digito);
		String resultado = n1 + n2;
		return resultado;
	}

	public boolean equals(Cpf cpf) {
		return this.numero == cpf.numero && this.digito == cpf.digito;
	}

	public String toString() {
		return "CPF: " + this.getCpf();
	}

	public static Cpf criarObjeto(Scanner s) {
		int num, dig;
		System.out.print("Informe o numero do CPF: ");
		num = s.nextInt();
		s.nextLine();
		System.out.print("Informe o digito verificador do CPF: ");
		dig = s.nextInt();
		s.nextLine();
		Cpf c = new Cpf(num, dig);
		return c;
	}
}