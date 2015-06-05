package com.acme.ado.classesGerais;

import com.acme.excecoes.AtributoInvalidoException;
import com.acme.excecoes.ObjetoExistenteException;
import com.acme.excecoes.ObjetoNaoExistenteException;
import com.acme.rn.classesGerais.Registro;

public interface InterfaceRepositorioIdentificaveis {
	public Registro buscar(String chave) throws AtributoInvalidoException, ObjetoNaoExistenteException;

	public void incluir(Registro id) throws AtributoInvalidoException,
			ObjetoExistenteException;

	public void alterar(Registro id) throws AtributoInvalidoException,
			ObjetoNaoExistenteException;

	public boolean excluir(String s) throws AtributoInvalidoException,
			ObjetoNaoExistenteException;

	public void listar();

}
