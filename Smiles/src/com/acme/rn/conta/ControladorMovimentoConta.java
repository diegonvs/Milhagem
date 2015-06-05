package com.acme.rn.conta;

import com.acme.ado.classesGerais.InterfaceRepositorioMovimentoConta;
import com.acme.ado.conta.RepositorioMovimentoConta;
import com.acme.excecoes.AtributoInvalidoException;
import com.acme.excecoes.ObjetoExistenteException;

public class ControladorMovimentoConta {
	// Atributos:
	public static InterfaceRepositorioMovimentoConta rmc = new RepositorioMovimentoConta();

	// Métodos:

	public void Inserir(MovimentoConta mc) throws AtributoInvalidoException,
			ObjetoExistenteException {
		mc.validar();
		if (mc.equals(null)) {
			throw new AtributoInvalidoException("MovimentoConta Nulo!");
		} else {
			try {
				rmc.incluir(mc);
			} catch (ObjetoExistenteException e) {
				System.out.println(e.getMessage());
			}

		}
	}
}
