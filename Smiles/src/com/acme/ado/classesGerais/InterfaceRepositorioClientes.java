package com.acme.ado.classesGerais;

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

	public void alterar(Cliente cliente) throws AtributoInvalidoException,ObjetoNaoExistenteException;

	public boolean excluir(Cpf cpf) throws AtributoInvalidoException,ObjetoNaoExistenteException;

	public Cliente[] buscaTodos();
}
