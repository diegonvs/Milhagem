package com.acme.testes.conta;

import com.acme.excecoes.AtributoInvalidoException;
import com.acme.rn.cliente.Cliente;
import com.acme.rn.conta.ContaMilhagemPremium;
import com.acme.rn.conta.IdentificadorConta;

public class TesteContaMilhagemPremium {

	public static void main(String[] args) throws AtributoInvalidoException {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente(108797804,10, "Diego", 18, 400, 0);
		IdentificadorConta id = new IdentificadorConta(100);
		ContaMilhagemPremium cmp = new ContaMilhagemPremium(id, cliente);
		cmp.Creditar(200, 50);
		System.out.println(cmp.getSaldo());
	}

}
