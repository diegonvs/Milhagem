package com.acme.rn.cliente;

import java.io.IOException;

import com.acme.ado.classesGerais.InterfaceRepositorioClientes;
import com.acme.ado.cliente.RepositorioClientes;
import com.acme.excecoes.AtributoInvalidoException;
import com.acme.excecoes.ObjetoExistenteException;
import com.acme.excecoes.ObjetoNaoExistenteException;
import com.acme.excecoes.SaldoInsuficienteException;
import com.acme.rn.conta.ControladorContaMilhagem;

public class ControladorCliente {
	// Atributos
	public static InterfaceRepositorioClientes rc1 = new RepositorioClientes();
	public static ControladorContaMilhagem ccm = new ControladorContaMilhagem();

	// M�todos
	public void Incluir(Cliente novo) throws AtributoInvalidoException,
			ObjetoExistenteException, SaldoInsuficienteException {
		novo.validar();
		if (novo.equals(null)) {
			throw new AtributoInvalidoException("Cliente nulo!");
		} else {
			// IdentificadorConta ic = new IdentificadorConta(
			// Long.parseLong(novo.getCpf().getCpf()));
			// ContaMilhagem r = new ContaMilhagem(ic, novo);
			try {
				ControladorCliente.rc1.incluir(novo);
				ccm.Inserir(novo.getCpf());
			} catch (ObjetoExistenteException e) {
				System.out.println(e.getMessage());
			}

		}

	}

	public void Alterar(Cliente novo, Cliente existente)
			throws AtributoInvalidoException, ObjetoNaoExistenteException {
		novo.validar();
		existente.validar();
		try {
			rc1.alterar(novo, existente);
		} catch (ObjetoNaoExistenteException e) {
			System.out.println(e.getMessage());
		} catch (ObjetoExistenteException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public void Excluir(Cpf cpf) throws AtributoInvalidoException,
			ObjetoNaoExistenteException {
		if (cpf.equals(null)) {
			throw new AtributoInvalidoException("Cpf nulo!");
		} else {
			try {
				rc1.excluir(cpf);
			} catch (ObjetoNaoExistenteException e) {
				System.out.println(e.getMessage());
			}

		}
	}

	public void Buscar(Cpf cpf) throws AtributoInvalidoException,
			ObjetoNaoExistenteException {
		if (cpf.equals(null)) {
			throw new AtributoInvalidoException("Cpf nulo!");
		} else {
			rc1.buscarporChave(cpf.getCpf());
		}
	}

	public void BuscarTodos() {
		rc1.buscaTodos();
	}
}