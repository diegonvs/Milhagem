package com.acme.testes.conta;

import com.acme.excecoes.AtributoInvalidoException;
import com.acme.excecoes.SaldoInsuficienteException;
import com.acme.rn.cliente.Cliente;
import com.acme.rn.cliente.Cpf;
import com.acme.rn.conta.ContaMilhagem;
import com.acme.rn.conta.IdentificadorConta;
import com.acme.rn.conta.MovimentoContaCredito;
import com.acme.rn.conta.MovimentoContaDebito;

public class TesteMovimentoContaCredito {

	public static void main(String[] args) throws AtributoInvalidoException, SaldoInsuficienteException {
		Cpf cpf = new Cpf("10879780410");
		Cliente cliente = new Cliente(cpf,"Diego", 18, 400, 0);
		IdentificadorConta identificadorconta = new IdentificadorConta(100);
		ContaMilhagem cm = new ContaMilhagem(identificadorconta, cliente);
		cm.Creditar(1000);
		MovimentoContaCredito mcc = new MovimentoContaCredito(cm, 200);
		cm.Debitar(100);
		MovimentoContaDebito mcd = new MovimentoContaDebito(cm, 100, cm.getCliente().getNome());
		System.out.println(mcc.toString());
		System.out.println(mcd.toString());
	}

}
