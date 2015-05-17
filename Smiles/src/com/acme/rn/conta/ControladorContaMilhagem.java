package com.acme.rn.conta;

import com.acme.ado.conta.RepositorioContaMilhagem;
import com.acme.rn.cliente.ControladorCliente;
import com.acme.rn.cliente.Cpf;

public class ControladorContaMilhagem {
	// Atributos:
	public static RepositorioContaMilhagem rcm1 = new RepositorioContaMilhagem();

	// M�todos:
	public void Inserir(Cpf c) {
		if (c.equals(null)) {
			System.out.println("Cpf Nulo!");
		} else {
			if (ControladorCliente.rc1.buscarporChave(c.getCpf()).equals(null)) {
				System.out.println("Cpf Não Encontrado !");
			} else {
				IdentificadorConta ic = new IdentificadorConta(Long.parseLong(c
						.getCpf()));
				ContaMilhagem cm = new ContaMilhagem(ic,
						ControladorCliente.rc1.buscarporChave(c.getCpf()));
				rcm1.incluir(cm);

			}
		}

	}

	public void Creditar(IdentificadorConta ic, int valor) {
		if (ic.equals(null)) {
			System.out.println("Identificador nulo!");
		} else {
			ContaMilhagem cmi = rcm1.buscar(ic);
			ContaMilhagem cm2 = new ContaMilhagem(ic, cmi.getCliente());
			rcm1.alterar(cmi.getIdentificadorconta(), cm2);

		}
	}

	public void Debitar(IdentificadorConta ic, int valor) {
		if (ic.equals(null)) {
			System.out.println("Identificador NULO! :-/ ");
		} else {
			ContaMilhagem cm2 = rcm1.buscar(ic);
			cm2.Debitar(valor);
			rcm1.alterar(ic, cm2);
			MovimentoConta mc = new MovimentoConta(cm2, valor);
			ControladorMovimentoConta.rmc.incluir(mc);
		}
	}

	public void Transferir(IdentificadorConta ic1, IdentificadorConta ic2,
			int valor) {
		if (ic1.equals(null) || ic2.equals(null)) {
			System.out.println("Idenficador Nulo!");
		} else {
			rcm1.buscar(ic1).Transferir(valor, rcm1.buscar(ic2));
			MovimentoConta mc = new MovimentoConta(rcm1.buscar(ic2), valor);
			ControladorMovimentoConta.rmc.incluir(mc);
		}
	}

	public RepositorioContaMilhagem BuscarTodos() {
		return rcm1;
	}

	public IdentificadorConta Buscar(IdentificadorConta ic, int valor) {
		if (ic.equals(null)) {
			System.out.println("Identificador Nulo!");
			return null;
		} else {
			if (rcm1.buscar(ic).equals(null)) {
				System.out.println("Não encontrado!");
				return null;
			} else {
				return ic;
			}
		}
	}

}
