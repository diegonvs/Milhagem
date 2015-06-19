package com.acme.rn.cliente;

import java.util.Scanner;
//FEITO!
public class Cpf {
	// Atributos
	private int numero;
	private int digito;
	private String cpf;

	// Construtores
	public Cpf(int numero, int digito) {
		this.setNumero(numero);
		this.setDigito(digito);
	}

	public Cpf(String cpf) {
		// Construtor sobrescrito que recebe uma String
		this.setCpf(cpf);
	}

	// Getters And Setters
	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getCpf() {
		String n1 = Integer.toString(this.numero);
		String n2 = Integer.toString(this.digito);
		String resultado = n1 + n2;
		return resultado;
	}

	public String getCpfString() {
		return this.cpf;
	}

	// Métodos
	public String toString() {
		return "CPF: " + this.getCpf();
	}

	public static Cpf criarObjeto(Scanner s) {
		System.out.print("Informe o numero do CPF: ");
		String cpf = s.nextLine();
		Cpf c = new Cpf(cpf);
		
		return c;

	}
}