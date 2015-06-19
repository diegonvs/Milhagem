package com.acme.ado.classesGerais;

import com.acme.excecoes.AtributoInvalidoException;
import com.acme.excecoes.ObjetoExistenteException;
import com.acme.excecoes.ObjetoNaoExistenteException;
import com.acme.rn.classesGerais.Registro;

public class RepositorioIdentificaveis implements
		InterfaceRepositorioIdentificaveis {

	public Registro[] elementos;
	public int qtd;

	// Construtor
	public RepositorioIdentificaveis() {
		elementos = new Registro[150];
		this.qtd = 0;
	}

	public Registro buscar(String chave) throws AtributoInvalidoException,ObjetoNaoExistenteException {
		Registro r = null;
		if(chave.equals(null)){
			throw new AtributoInvalidoException("Chave nula!");
		}
		for (int i = 0; i < qtd; i++) {
			if (chave.equals(elementos[i].getChave())) {
				r = elementos[i];
				return r;
			}
		}
		throw new ObjetoNaoExistenteException("Objeto não encontrado!");
	}

	public void incluir(Registro id) throws AtributoInvalidoException,
			ObjetoExistenteException {
			if (qtd < elementos.length && id != null) {
				elementos[qtd++] = id;
			} else {
				throw new ObjetoExistenteException(
						"O repositório está cheio ou cliente é nulo!");
			}
	}

	public void alterar(Registro id) throws AtributoInvalidoException,
			ObjetoNaoExistenteException {
		if (id.equals(null)) {
			throw new AtributoInvalidoException("Parâmetro null!");
		} else {
			for (int i = 0; i < qtd; i++) {
				if (elementos[i].equals(id)) {
					elementos[i] = id;
					break;
				} else {
					throw new ObjetoNaoExistenteException(
							"Objeto não encontrado!");
				}
			}
		}
	}

	public boolean excluir(String s) throws AtributoInvalidoException,
			ObjetoNaoExistenteException {
		boolean r = false;
		if (this.buscar(s).equals(null)) {
			throw new AtributoInvalidoException("Atributo Inválido!");
		} else {
			for (int i = 0; i < qtd; i++) {
				if (this.elementos[i].getChave().equals(s)) {
					elementos[i] = null;
					elementos[i] = elementos[qtd];
					elementos[qtd] = null;
					r = true;
					qtd--;
					break;
				} else {
					throw new ObjetoNaoExistenteException(
							"Objeto não encontrado");
				}
			}
			return r;
		}
	}

	public void listar() {
		System.out.println("--- Identificáveis: ---");
		for (int i = 0; i < qtd; i++) {
			System.out.println("Dados do cliente: " + (i + 1));
			System.out.println(elementos[i].toString());
		}
		System.out.println("----------------------------");
	}

}
