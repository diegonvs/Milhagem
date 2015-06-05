package com.acme.rn.conta;

import com.acme.excecoes.AtributoInvalidoException;
import com.acme.rn.cliente.Cliente;

public class ContaMilhagemPremium extends ContaMilhagem {
	private double fatorMultiplicacaoCredito;

	public void Creditar(int valor, double fatorMult)
			throws AtributoInvalidoException {
		if (valor <= 0) {
			throw new AtributoInvalidoException(
					"Valor precisa ser maior que zero!");
		}
		super.Creditar((int) (valor * fatorMult));
	}

	public void Creditar(int valor) throws AtributoInvalidoException {
		if (valor <= 0) {
			throw new AtributoInvalidoException(
					"Valor precisa ser maior que zero");
		}
		this.Creditar(valor, this.fatorMultiplicacaoCredito);
	}

	// Getters and Setters
	public double getFatorMultiplicacaoCredito() {
		return fatorMultiplicacaoCredito;
	}

	public void setFatorMultiplicacaoCredito(double fatorMultiplicacaoCredito) {
		this.fatorMultiplicacaoCredito = fatorMultiplicacaoCredito;
	}

	// Construtor
	public ContaMilhagemPremium(IdentificadorConta id, Cliente cliente,
			double fatorMultiplicacaoCredito) {
		super(id, cliente);
		this.fatorMultiplicacaoCredito = fatorMultiplicacaoCredito;
	}

	public ContaMilhagemPremium(IdentificadorConta id, Cliente cliente) {
		super(id, cliente);
		this.fatorMultiplicacaoCredito = 1;
	}
}
