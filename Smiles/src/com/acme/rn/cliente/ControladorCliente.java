package com.acme.rn.cliente;

import com.acme.ado.cliente.RepositorioClientes;
import com.acme.ado.conta.RepositorioContaMilhagem;
import com.acme.rn.conta.ContaMilhagem;
import com.acme.rn.conta.IdentificadorConta;

public class ControladorCliente {
	public static RepositorioClientes rc1;
	public static RepositorioContaMilhagem rcm1;

	public void Incluir(Cliente novo) {// feito!
		if (novo.equals(null)) {
			System.out.println("Cliente nulo!");
		} else {
			IdentificadorConta ic = new IdentificadorConta(Long.parseLong(novo
					.getCpf()));
			ContaMilhagem r = new ContaMilhagem(ic, novo);
			rc1.incluir(novo);
			rcm1.incluir(r);
		}

	}
 //Dúvida: como eu posso "e não fazer mais nada."
 //TODO- mudar a classe Alterar no repositório de clientes com HAZINX
	public void Alterar(Cliente c) {
		if (c.equals(null)) {
			System.out.println("Cliente nulo!");
		} else {
			rc1.alterar(c);
		}
	}
	
	public void Excluir(Cpf cpf){
		if (cpf.equals(null)) {
			System.out.println("Cpf nulo!");
		} else {
			rc1.excluir(cpf);
		}
	}
	
	public void Buscar(Cpf cpf){
		if (cpf.equals(null)) {
			System.out.println("Cpf nulo!");
		} else {
			rc1.buscar(cpf.getCpf());
		}
	}
	//Dúvida: tá certo mesmo?! :p
	public void BuscarTodos(){
		rc1.listar();
	}
}