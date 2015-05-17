package com.acme.testes.conta;

import com.acme.ado.conta.RepositorioContaMilhagem;
import com.acme.rn.cliente.Cliente;
import com.acme.rn.conta.ContaMilhagem;
import com.acme.rn.conta.IdentificadorConta;

public class TesteRepositorioContaMilhagem {

	public static void main(String[] args) {
		// iniciando as contas milhagem.
		Cliente c1 = new Cliente("10879780410", "Diego Nascimento", 18, 100, 0);
		IdentificadorConta ic1 = new IdentificadorConta(100);
		ContaMilhagem cm1 = new ContaMilhagem(ic1, c1);

		Cliente c2 = new Cliente("66842979447", "Teste c2", 50, 10000, 1);
		IdentificadorConta ic2 = new IdentificadorConta(200);
		ContaMilhagem cm2 = new ContaMilhagem(ic2, c2);

		Cliente c3 = new Cliente("17844893109", "Teste c3", 67, 500, 0);
		IdentificadorConta ic3 = new IdentificadorConta(300);
		ContaMilhagem cm3 = new ContaMilhagem(ic3, c3);

		//Cliente c4 = new Cliente("97344615401", "Não está no Repositório",
			//	99, 9999, 0);
		IdentificadorConta ic4 = new IdentificadorConta(400);
		//ContaMilhagem cm4 = new ContaMilhagem(ic4, c4);
		// //////////////////////////////////////////////////////////////////////////////
		RepositorioContaMilhagem rcm1 = new RepositorioContaMilhagem();
		// //////////////////////////////////////////////////////////////////////////////
		// Incluindo as conta milhagens cm1,cm2,cm3 [A CONTA MILHAGEM "cm4" não
		// foi inserida!]
		rcm1.incluir(cm1);
		rcm1.incluir(cm2);
		rcm1.incluir(cm3);
		// no método buscar quando se retorna "null" é pq a conta existe qd
		// retorna true não existe.
		// //////////////////////////////////////////////////////////////////////////////
		System.out.println(rcm1.buscar(ic2));
		System.out.println(rcm1.buscar(ic4)); // não está no repositório!
		// //////////////////////////////////////////////////////////////////////////////
		System.out.println(rcm1.excluir(cm3));
		System.out.println(rcm1.buscar(ic3));// foi removida na :32
		// //////////////////////////////////////////////////////////////////////////////
		// //////////////////////////////////////////////////////////////////////////////
		System.out.println(rcm1.buscar(ic1).toString());
		rcm1.listar();
		System.out.println(rcm1.buscarpeloCpf(c1.getCpf().getCpf()));
	}

}
