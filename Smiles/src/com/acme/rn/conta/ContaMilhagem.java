package com.acme.rn.conta;

import java.util.Scanner;

import com.acme.rn.classesGerais.Identificavel;
import com.acme.rn.cliente.Cliente;

public class ContaMilhagem extends Identificavel {
	// Atributos:
	private IdentificadorConta identificadorconta;
	private Cliente cliente;
	private int saldo;
	private boolean ativa;

	// Métodos
	public void Creditar(int valor) {
		if (valor > 0) {
			this.saldo = valor + saldo;
		} else {
			System.out.println("Valor precisa ser maior que zero.");
		}

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
		String s = this.identificadorconta.toString() + "\n"
				+ this.cliente.toString();
		return s;
	}

	public String getChave() {
		return Long.toString(this.identificadorconta.getNumero());
	}

	public static ContaMilhagem criarObjeto(Scanner s) {
		IdentificadorConta ic2;
		Cliente c2;
		ic2 = IdentificadorConta.criarObjeto(s);
		c2 = Cliente.criarObjeto(s);
		ContaMilhagem c = new ContaMilhagem(ic2, c2);
		return c;
	}

	// Construtores:
	public ContaMilhagem(IdentificadorConta identificadorconta, Cliente cliente) {
		this.identificadorconta = identificadorconta;
		this.cliente = cliente;
		this.setSaldo(0);
		this.setAtiva(true);
	}

	// Getters and Setters:
	public IdentificadorConta getIdentificadorconta() {
		return identificadorconta;
	}

	public void setIdentificadorconta(IdentificadorConta identificadorconta) {
		this.identificadorconta = identificadorconta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

}