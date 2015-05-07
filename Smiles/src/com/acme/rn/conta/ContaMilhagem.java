package com.acme.rn.conta;

import java.util.Scanner;

import com.acme.rn.cliente.Cliente;

public class ContaMilhagem {
	public IdentificadorConta identificadorconta;
	public Cliente cliente;
	private int saldo;
	private boolean ativa;

	public void Creditar(int valor) {
		this.saldo = valor + saldo;
	}

	public void Debitar(int valor) {
		if (saldo > valor) {
			this.saldo = saldo - valor;
		} else {
			System.out.println("Saldo insuficiente!");
		}
	}

	public void Transferir(int valor, ContaMilhagem c) {
		c.Creditar(valor);
		this.Debitar(valor);
	}

	public void Desativar() {
		this.ativa = false;
	}

	public void Reativar() {
		this.ativa = true;
	}

	public String toString() {
		String s = this.identificadorconta.toString() + "\n" + this.cliente.toString();
		return s;
	}

	public ContaMilhagem(IdentificadorConta identificadorconta, Cliente cliente) {
		this.identificadorconta = identificadorconta;
		this.cliente = cliente;
		this.setSaldo(0);
		this.setAtiva(true);
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public static ContaMilhagem criarObjeto(Scanner s) {
		IdentificadorConta ic2;
		Cliente c2;
		ic2 = IdentificadorConta.criarObjeto(s);
		c2 = Cliente.criarObjeto(s);
		ContaMilhagem c = new ContaMilhagem(ic2, c2);
		return c;
	}
}
