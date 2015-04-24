package com.acme.testes.conta;
import java.util.Date;

import com.acme.ado.conta.RepositorioMovimentoConta;
import com.acme.rn.cliente.Cliente;
import com.acme.rn.conta.ContaMilhagem;
import com.acme.rn.conta.IdentificadorConta;
import com.acme.rn.conta.MovimentoConta;

public class TesteRepositorioMovimentoConta {

	public static void main(String[] args) {
		// iniciando os movimentos de conta.
		Cliente c1 = new Cliente("10879780410", "Diego Nascimento", 18, 100, 0);
		IdentificadorConta ic1 = new IdentificadorConta(100);
		ContaMilhagem cm1 = new ContaMilhagem(ic1, c1);

		Cliente c2 = new Cliente("66842979447", "Teste c2", 50, 10000, 1);
		IdentificadorConta ic2 = new IdentificadorConta(200);
		ContaMilhagem cm2 = new ContaMilhagem(ic2, c2);

		// //////////////////////////////////////////////////////////////////////////////
		// Iniciando o repositório!
		RepositorioMovimentoConta rmc1 = new RepositorioMovimentoConta();
		// //////////////////////////////////////////////////////////////////////////////
		MovimentoConta mc1 = new MovimentoConta(cm1, 200, cm2,
				cm1.cliente.nome, new Date());
		MovimentoConta mc2 = new MovimentoConta(cm2, 200, cm1,
				cm2.cliente.nome, new Date());
		// Incluindo os movimentos conta mc1 e mc2
		rmc1.incluir(mc1);
		rmc1.incluir(mc2);
		// //////////////////////////////////////////////////////////////////////////////
		// Listando o repositorio.
		rmc1.listar();

	}

}
