package com.acme.rn.conta;

import java.util.Date;

import com.acme.ado.cliente.RepositorioClientes;
import com.acme.ado.conta.RepositorioContaMilhagem;
import com.acme.ado.conta.RepositorioMovimentoConta;
import com.acme.rn.cliente.Cliente;
import com.acme.rn.cliente.ControladorCliente;
import com.acme.rn.cliente.Cpf;

public class ControladorContaMilhagem extends ContaMilhagem {

	// Construtor
	public ControladorContaMilhagem(IdentificadorConta identificadorconta,
			Cliente cliente) {
		super(identificadorconta, cliente);
		// TODO Auto-generated constructor stub
	}

	public static ControladorCliente controladorCliente;
	public static RepositorioContaMilhagem rcm;
	public static RepositorioClientes rc;
	public static RepositorioMovimentoConta rmc;

	public void Inserir(Cpf c) {
		if (c.equals(null)) {
			System.out.println("Cpf Nulo!");
		} else {
			if (rcm.buscarpeloCpf(c.getCpf()).equals(null)) {
				System.out.println("Cpf Não Encontrado !");
			} else {
				// Deveria retornar um cliente.
				IdentificadorConta ic = new IdentificadorConta(Long.parseLong(c
						.getCpf()));
				ContaMilhagem cm = new ContaMilhagem(ic, rc.buscar(c.getCpf()));
				rcm.incluir(cm);
				controladorCliente.Incluir(rc.buscar(c.getCpf()));

			}
		}

	}

	public void Creditar(IdentificadorConta ic, int valor) {
		if (ic.equals(null)) {
			System.out.println("Identificador nulo!");
		} else {
			// TODO - PRECISO DO ALTERAR!
			ContaMilhagem cmi = rcm.buscar(ic);
			ContaMilhagem cm2 = new ContaMilhagem(ic, cmi.cliente);
			rcm.alterar(cmi.identificadorconta, cm2);

		}
	}

	public void Debitar(IdentificadorConta ic, int valor) {
		if (ic.equals(null)) {
			System.out.println("Identificador NULO! :-/ ");
		} else {
			ContaMilhagem cm2 = rcm.buscar(ic);
			cm2.Debitar(valor);
			rcm.alterar(ic, cm2);
			MovimentoConta mc = new MovimentoConta(cm2, valor, new Date());
			rmc.incluir(mc);

			//Instanciar MovimentoDébito!

		}
	}

	public void Transferir(IdentificadorConta ic1, IdentificadorConta ic2,
			int valor) {
		if (ic1.equals(null) || ic2.equals(null)) {
			System.out.println("Idenficador Nulo!");
		} else {
			rcm.buscar(ic1).Transferir(valor, rcm.buscar(ic2));
			MovimentoConta mc = new MovimentoConta(rcm.buscar(ic1), valor,
					rcm.buscar(ic2), rcm.buscar(ic1).cliente.getNome(),
					new Date());
			// TODO- COMASSIM PASSAR PARA O CONTROLADOR DE MOVIMENTO CONTAS? TA
			// DE ZUA NÉ? SOPODE XOVI

		}
	}

	public IdentificadorConta Buscar(IdentificadorConta ic, int valor) {
		if (ic.equals(null)) {
			System.out.println("Identificador Nulo!");
			return null;
		} else {
			if (rcm.buscar(ic).equals(null)) {
				System.out.println("Não encontrado!");
				return null;
			} else {
				return ic;
			}
		}
	}

	public RepositorioContaMilhagem BuscarTodos() {
		return rcm;
	}

}
