package com.acme.testes.conta;

import java.io.IOException;
import java.util.Arrays;

import com.acme.ado.classesGerais.IOClientes;
import com.acme.ado.classesGerais.IOConta;
import com.acme.ado.classesGerais.IORepositorios;
import com.acme.excecoes.AtributoInvalidoException;
import com.acme.excecoes.ObjetoExistenteException;
import com.acme.excecoes.ObjetoNaoExistenteException;
import com.acme.rn.cliente.Cliente;
import com.acme.rn.cliente.Cpf;
import com.acme.rn.conta.ContaMilhagem;
import com.acme.rn.conta.IdentificadorConta;

public class TesteSatanistas {

	public static void main(String[] args) {
		Cpf cpf = new Cpf("10879780410");
		Cliente c = new Cliente(cpf, "Diego", 18, 100, 0);
		IdentificadorConta ic = new IdentificadorConta(111);
		ContaMilhagem cm = new ContaMilhagem(ic, c);
		// ////////////////////////////////////
		Cpf cpf2 = new Cpf("66666666666");
		Cliente c2 = new Cliente(cpf2, "Dollyinho", 13, 200, 1);
		IdentificadorConta ic2 = new IdentificadorConta(Long.parseLong(cpf2.getCpf()));
		ContaMilhagem cm2 = new ContaMilhagem(ic2, c2);
		IOConta ioConta = new IOConta();
		IORepositorios io = new IORepositorios<ContaMilhagem>();
		IOClientes ioC = new IOClientes();
		try {
			ioConta.incluir(cm2);
			//ioC.incluir(c);
			//ioC.incluir(c2);
		} catch (ObjetoExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AtributoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Arrays.toString(ioC.buscaTodos()));

	}

}
