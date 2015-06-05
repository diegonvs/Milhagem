package com.acme.testes.cliente;

import com.acme.ado.cliente.RepositorioClientes;
import com.acme.excecoes.AtributoInvalidoException;
import com.acme.rn.cliente.Cliente;

public class TesteRepositorioClientes {

	public static void main(String[] args) throws AtributoInvalidoException {
		///Inicializando o repositório.////////////////////////////////////////////////////
		RepositorioClientes rc = new RepositorioClientes();
		///////////////////////////////////////////////////////////////////////////////////
		///Iniciando os clientes.//////////////////////////////////////////////////////////
		Cliente c1 = new Cliente("10879780410", "Diego Nascimento", 18, 100, 0);
		Cliente c2 = new Cliente(123456789,10, "Aretruza Josefina", 50,
				16000, 0);
		Cliente c3 = new Cliente(348931603,70, "Jesus de Nazaré da Mata", 18, 100, 0);
		Cliente c4 = new Cliente(147265938,38, "Exú Caveirinha da Silva", 50,
				16000, 0);
		Cliente c5 = new Cliente(888911412,67, "Paul Walker Andador", 18, 100, 0);
		Cliente c6 = new Cliente(963368434,10, "Estranho na Luz do Mundo", 50,
				16000, 0);
		///Incluindo os clientes no repositório:///////////////////////////////////////////
		rc.incluir(c1);
		rc.incluir(c2);
		rc.incluir(c3);
		rc.incluir(c4);
		rc.incluir(c5);
		rc.incluir(c6);
		rc.buscaTodos();
		///////////////////////////////////////////////////////////////////////////////////
		System.out.println(rc.buscarporChave("10879780410"));
		System.out.println(rc.buscarporChave("12345678910"));
		System.out.println(rc.excluir(c4.getCpf()));///Excluindo o cliente "c4" (Nome:"Exú Caveirinha da Silva) do repositório
		System.out.println("Segundo listar sem o cliente c4(Exú Caveirinha da Silva): ");
		rc.buscaTodos();
	}
	
}