package com.acme.testes.conta;

import java.io.IOException;

import com.acme.ado.classesGerais.IORepositorios;
import com.acme.excecoes.AtributoInvalidoException;
import com.acme.excecoes.ObjetoExistenteException;
import com.acme.excecoes.ObjetoNaoExistenteException;
import com.acme.rn.cliente.Cliente;
import com.acme.rn.cliente.Cpf;
import com.acme.rn.conta.ContaMilhagemPremium;
import com.acme.rn.conta.IdentificadorConta;

public class TesteContaMilhagemPremium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cpf cpf = new Cpf("10879780410");
		Cliente cliente = new Cliente(cpf,"Diego",18,400,0);
		IdentificadorConta id = new IdentificadorConta(100);
		//incluindo um cliente;
		IORepositorios<Cliente> io = new IORepositorios<Cliente>();
		Cpf cpf2 = new Cpf("07416996481");
		Cliente c2 = new Cliente(cpf2,"hazinho",18,45000,0);
			//io.incluir(cliente);
			//io.alterar(cliente.getCpf().getCpf(), c2, true);
			//io.excluir(cliente.getCpf().getCpf(), true);
			//io.alterar(cliente.getCpf().getCpf(),(Cliente) c2, true);
			System.out.println(io.buscar(c2.getCpf().getCpf(), true));
	}
}
