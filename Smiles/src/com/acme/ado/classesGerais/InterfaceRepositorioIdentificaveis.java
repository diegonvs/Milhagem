package com.acme.ado.classesGerais;

import java.io.IOException;

import com.acme.excecoes.AtributoInvalidoException;
import com.acme.excecoes.ObjetoExistenteException;
import com.acme.excecoes.ObjetoNaoExistenteException;
import com.acme.rn.classesGerais.Registro;

public interface InterfaceRepositorioIdentificaveis<T extends Registro> {
	public Registro buscar(String chave) throws AtributoInvalidoException, ObjetoNaoExistenteException;

	public void incluir(T id) throws AtributoInvalidoException,
			ObjetoExistenteException;

	public void alterar(T id) throws AtributoInvalidoException,
			ObjetoNaoExistenteException;

	public boolean excluir(String s) throws AtributoInvalidoException,
			ObjetoNaoExistenteException;

	public Registro[] listar();

}
