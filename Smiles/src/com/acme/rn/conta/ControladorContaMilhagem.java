package com.acme.rn.conta;

import com.acme.ado.classesGerais.InterfaceRepositorioContaMilhagem;
import com.acme.ado.conta.RepositorioContaMilhagem;
import com.acme.excecoes.AtributoInvalidoException;
import com.acme.excecoes.ObjetoExistenteException;
import com.acme.excecoes.ObjetoNaoExistenteException;
import com.acme.excecoes.SaldoInsuficienteException;
import com.acme.rn.cliente.ControladorCliente;
import com.acme.rn.cliente.Cpf;

public class ControladorContaMilhagem {
	// Atributos:
	public static InterfaceRepositorioContaMilhagem rcm1 = new RepositorioContaMilhagem();
	public ControladorContaMilhagem ccm = new ControladorContaMilhagem();

	// M�todos:
	public void Inserir(Cpf c) throws AtributoInvalidoException,
			ObjetoExistenteException {
		try {
			rcm1.buscarpeloCpf(c.getCpf()).validar();
		} catch (ObjetoNaoExistenteException e) {
			System.out.println(e.getMessage());
		}
		if (c.equals(null)) {
			throw new AtributoInvalidoException("Cpf null!");
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

	public void Creditar(IdentificadorConta ic, int valor)
			throws AtributoInvalidoException, ObjetoNaoExistenteException {
		if (ic.equals(null)) {
			throw new AtributoInvalidoException("Identificador nulo!");
		} else {
			try {
				ContaMilhagem cmi = rcm1.buscar(ic);
				ContaMilhagem cm2 = new ContaMilhagem(ic, cmi.getCliente());
				rcm1.alterar(cmi.getIdentificadorconta(), cm2);
			} catch (ObjetoNaoExistenteException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void Debitar(IdentificadorConta ic, int valor)
			throws AtributoInvalidoException, SaldoInsuficienteException,
			ObjetoNaoExistenteException, ObjetoExistenteException {
		if (ic.equals(null)) {
			throw new AtributoInvalidoException("Identificador NULO! :-/ ");
		} else {
			try {
				ContaMilhagem cm2 = rcm1.buscar(ic);
				cm2.Debitar(valor);
				rcm1.alterar(ic, cm2);
				MovimentoContaDebito mc = new MovimentoContaDebito(cm2, valor,
						cm2.getCliente().getNome());
				ControladorMovimentoConta.rmc.incluir(mc);
			} catch (SaldoInsuficienteException e) {
				System.out.println(e.getMessage());
			}

		}
	}

	public void Transferir(IdentificadorConta ic1, IdentificadorConta ic2,
			int valor) throws AtributoInvalidoException,
			SaldoInsuficienteException, ObjetoExistenteException {

		if (ic1.equals(null) || ic2.equals(null)) {
			throw new AtributoInvalidoException("Idenficador Nulo!");
		} else {
			try {
				rcm1.buscar(ic1).Transferir(valor, rcm1.buscar(ic2));
				MovimentoContaTransferencia mc = new MovimentoContaTransferencia(
						rcm1.buscar(ic1), valor, rcm1.buscar(ic2));
				ControladorMovimentoConta.rmc.incluir(mc);
			} catch (SaldoInsuficienteException e) {
				System.out.println(e.getMessage());
			}

		}
	}

	public RepositorioContaMilhagem BuscarTodos() {
		return (RepositorioContaMilhagem) rcm1;
	}

	public IdentificadorConta Buscar(IdentificadorConta ic, int valor)
			throws AtributoInvalidoException, ObjetoNaoExistenteException {
		if (ic.equals(null)) {
			throw new AtributoInvalidoException("Identificador Nulo!");
		} else {
			if (rcm1.buscar(ic).equals(null)) {
				throw new ObjetoNaoExistenteException("Não encontrado!");
			} else {
				return ic;
			}
		}
	}

}
