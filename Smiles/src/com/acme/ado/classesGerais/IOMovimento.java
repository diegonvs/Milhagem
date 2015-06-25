package com.acme.ado.classesGerais;

import java.io.FileWriter;
import java.io.IOException;

import com.acme.excecoes.AtributoInvalidoException;
import com.acme.excecoes.ObjetoExistenteException;
import com.acme.rn.conta.MovimentoConta;

public class IOMovimento {
	FileWriter file;
	IORepositorios<MovimentoConta> io = new IORepositorios<MovimentoConta>();

	public void incluir(MovimentoConta m) throws ObjetoExistenteException {

		try {
			io.incluir(m);
		} catch (ObjetoExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AtributoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
