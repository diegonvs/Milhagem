package com.acme.testes.conta;

import com.acme.ado.conta.RepositorioMovimentoConta;
import com.acme.excecoes.AtributoInvalidoException;
import com.acme.excecoes.ObjetoExistenteException;
import com.acme.rn.cliente.Cliente;
import com.acme.rn.conta.ContaMilhagem;
import com.acme.rn.conta.IdentificadorConta;
import com.acme.rn.conta.MovimentoConta;
import com.acme.rn.conta.MovimentoContaCredito;
import com.acme.rn.conta.MovimentoContaDebito;

public class TesteRepositorioMovimentoConta {

	public static void main(String[] args) throws ObjetoExistenteException,
			AtributoInvalidoException {
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
		MovimentoConta mc1 = new MovimentoContaDebito(cm1, 200, cm1
				.getCliente().getNome());
		MovimentoConta mc2 = new MovimentoContaCredito(cm2, 200);
		// Incluindo os movimentos conta mc1 e mc2
		rmc1.incluir(mc1);
		rmc1.incluir(mc2);
		// //////////////////////////////////////////////////////////////////////////////
		// Listando o repositorio.
		rmc1.listar();

	}

}
