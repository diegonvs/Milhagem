package com.acme.testes.conta;

import com.acme.ado.classesGerais.RepositorioIdentificaveis;
import com.acme.rn.classesGerais.Identificavel;
import com.acme.rn.cliente.Cliente;
import com.acme.rn.conta.ContaMilhagem;
import com.acme.rn.conta.IdentificadorConta;

public class TesteRepositorioIdentificaveis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepositorioIdentificaveis ri = new RepositorioIdentificaveis();
		Identificavel i1 = new Identificavel();
		IdentificadorConta identificadorconta = new IdentificadorConta(200);
		Cliente cliente = new Cliente("10879780410","Diego Nascimento",18,400,0);
		ContaMilhagem cm = new ContaMilhagem(identificadorconta, cliente);
		ri.incluir(cliente);
		ri.incluir(i1);
		ri.incluir(cm);
		ri.listar();
		ri.elementos.toString();
	}
}
