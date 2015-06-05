package com.acme.rn.classesGerais;

import com.acme.excecoes.AtributoInvalidoException;

public abstract class Registro {
	// Métodos:
	public abstract String getChave() throws AtributoInvalidoException;

	public abstract void validar() throws AtributoInvalidoException;
}
