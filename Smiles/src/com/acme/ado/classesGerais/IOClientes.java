package com.acme.ado.classesGerais;

import com.acme.excecoes.AtributoInvalidoException;
import com.acme.excecoes.ObjetoExistenteException;
import com.acme.excecoes.ObjetoNaoExistenteException;
import com.acme.rn.cliente.Cliente;
import com.acme.rn.cliente.Cpf;
import java.io.*;
public class IOClientes implements InterfaceRepositorioClientes {

	public IOClientes() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Cliente buscarporChave(String chave)
			throws AtributoInvalidoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void incluir(Cliente c) throws AtributoInvalidoException,
			ObjetoExistenteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Cliente cliente) throws AtributoInvalidoException,
			ObjetoNaoExistenteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean excluir(Cpf cpf) throws AtributoInvalidoException,
			ObjetoNaoExistenteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cliente[] buscaTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
