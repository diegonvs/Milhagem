package com.acme.rn.conta;

import com.acme.ado.conta.RepositorioMovimentoConta;

public class ControladorMovimentoConta {
	// Atributos:
	public static RepositorioMovimentoConta rmc = new RepositorioMovimentoConta();

	// Métodos:
	public void Inserir(MovimentoConta mc) {
		if (mc.equals(null)) {
			System.out.println("MovimentoConta Nulo!");
		} else {
			rmc.incluir(mc);
		}
	}
}
