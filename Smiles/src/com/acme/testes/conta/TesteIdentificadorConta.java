package com.acme.testes.conta;

import com.acme.excecoes.AtributoInvalidoException;
import com.acme.rn.conta.IdentificadorConta;

public class TesteIdentificadorConta {

	public static void main(String[] args) throws AtributoInvalidoException {
		// TODO Auto-generated method stub
		IdentificadorConta iC = new IdentificadorConta(1234);
		System.out.println(iC.verificarValidadeDigito(10)); //digito calculado para 1234.
		System.out.println(iC.verificarValidadeDigito(30)); //digito "randomico"
		System.out.println(iC.calcularDigitoVerificador(1234)); //método para cálcular o dígito verificador
		System.out.println(iC.toString()); //método toString :)
		////////////////////////////////////////////////////////
		
	}

}
