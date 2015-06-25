package com.acme.ado.classesGerais;

import java.io.IOException;

import com.acme.excecoes.AtributoInvalidoException;
import com.acme.excecoes.ObjetoExistenteException;
import com.acme.excecoes.ObjetoNaoExistenteException;
import com.acme.rn.cliente.Cliente;
import com.acme.rn.cliente.Cpf;

public interface InterfaceRepositorioClientes {
	public Cliente buscarporChave(String chave)
			throws AtributoInvalidoException;

	public void incluir(Cliente c) throws AtributoInvalidoException,
			ObjetoExistenteException;

	public void excluir(Cpf cpf) throws AtributoInvalidoException,
			ObjetoNaoExistenteException;

	public Cliente[] buscaTodos();

	public void alterar(Cliente novo, Cliente existente)
			throws AtributoInvalidoException, ObjetoNaoExistenteException, ObjetoExistenteException, IOException;

}
