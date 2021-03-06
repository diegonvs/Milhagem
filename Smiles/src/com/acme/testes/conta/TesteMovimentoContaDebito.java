package com.acme.testes.conta;

import com.acme.excecoes.AtributoInvalidoException;
import com.acme.excecoes.SaldoInsuficienteException;
import com.acme.rn.cliente.Cliente;
import com.acme.rn.cliente.Cpf;
import com.acme.rn.conta.ContaMilhagem;
import com.acme.rn.conta.IdentificadorConta;
import com.acme.rn.conta.MovimentoContaDebito;

public class TesteMovimentoContaDebito {
	public static void main(String[] args) throws AtributoInvalidoException,
			SaldoInsuficienteException {
		Cpf cpf = new Cpf("10879780410");
		Cliente cliente = new Cliente(cpf, "Diego", 18, 400, 0);
		IdentificadorConta identificadorconta = new IdentificadorConta(100);
		ContaMilhagem cm = new ContaMilhagem(identificadorconta, cliente);
		cm.Creditar(1000);
		MovimentoContaDebito mcd = new MovimentoContaDebito(cm, 200, cm
				.getCliente().getNome());
		cm.Debitar(100);
		MovimentoContaDebito mcd2 = new MovimentoContaDebito(cm, 100, cm
				.getCliente().getNome());
		cm.Debitar(300);
		System.out.println(mcd2.toString());
		System.out.println(mcd.toString());
	}
}
