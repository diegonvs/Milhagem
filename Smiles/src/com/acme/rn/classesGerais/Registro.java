package com.acme.rn.classesGerais;

import com.acme.excecoes.AtributoInvalidoException;

public abstract class Registro {
	// M�todos:
	public abstract String getChave() throws AtributoInvalidoException;

	public abstract void validar() throws AtributoInvalidoException;
}
