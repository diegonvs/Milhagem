package com.acme.rn.cliente;

import com.acme.ado.cliente.RepositorioClientes;
import com.acme.rn.conta.ControladorContaMilhagem;

public class ControladorCliente {
	//Atributos
	public static RepositorioClientes rc1 = new RepositorioClientes();
	public static ControladorContaMilhagem ccm = new ControladorContaMilhagem();
	
	//Métodos
	public void Incluir(Cliente novo) {
		if (novo.equals(null)) {
			System.out.println("Cliente nulo!");
		} else {
			//IdentificadorConta ic = new IdentificadorConta(
					//Long.parseLong(novo.getCpf().getCpf()));
			//ContaMilhagem r = new ContaMilhagem(ic, novo);
			ControladorCliente.rc1.incluir(novo);
			ccm.Inserir(novo.getCpf());
		}

	}

	public void Alterar(Cliente c) {
		if (c.equals(null)) {
			System.out.println("Cliente nulo!");
		} else {
			rc1.alterar(c);
		}
	}

	public void Excluir(Cpf cpf) {
		if (cpf.equals(null)) {
			System.out.println("Cpf nulo!");
		} else {
			rc1.excluir(cpf);
		}
	}

	public void Buscar(Cpf cpf) {
		if (cpf.equals(null)) {
			System.out.println("Cpf nulo!");
		} else {
			rc1.buscarporChave(cpf.getCpf());
		}
	}

	public void BuscarTodos() {
		rc1.buscaTodos();
	}
}