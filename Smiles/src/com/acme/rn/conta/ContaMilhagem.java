package com.acme.rn.conta;

import java.util.Scanner;

import com.acme.excecoes.AtributoInvalidoException;
import com.acme.excecoes.SaldoInsuficienteException;
import com.acme.rn.classesGerais.Registro;
import com.acme.rn.cliente.Cliente;

public class ContaMilhagem extends Registro {
	// Atributos:
	private IdentificadorConta identificadorconta;
	private Cliente cliente;
	private int saldo;
	private boolean ativa;

	// Métodos
	public void Creditar(int valor) throws AtributoInvalidoException {
		if (valor > 0) {
			this.saldo = valor + saldo;
		} else {
			throw new AtributoInvalidoException(
					"Valor precisa ser maior que zero.");
		}

	}

	public void Debitar(int valor) throws AtributoInvalidoException,
			SaldoInsuficienteException {
		if (valor <= 0) {
			throw new AtributoInvalidoException(
					"Valor precisa ser maior que zero!");
		}
		if (saldo > valor) {
			this.saldo = saldo - valor;
		} else {
			throw new SaldoInsuficienteException("Saldo Insuficiente!");
		}
	}

	public void Transferir(int valor, ContaMilhagem c)
			throws AtributoInvalidoException, SaldoInsuficienteException {
		if (valor <= 0) {
			throw new AtributoInvalidoException(
					"Valor precisa ser maior que zero!");
		}
		try {
			c.Creditar(valor);
			this.Debitar(valor);
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}

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

	@Override
	public void validar() {
		// TODO Auto-generated method stub
		if (identificadorconta.equals(null)) {
			System.err.println("Identificador não pode ser null!");
		}
		if (cliente.equals(null)) {
			System.err.println("Cliente não pode ser null!");
		}
		if (this.saldo < 0) {
			System.err.println("Saldo não pode ser negativo!");
		}
	}

}