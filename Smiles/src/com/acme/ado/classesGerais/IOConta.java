package com.acme.ado.classesGerais;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.acme.excecoes.AtributoInvalidoException;
import com.acme.excecoes.ObjetoExistenteException;
import com.acme.excecoes.ObjetoNaoExistenteException;
import com.acme.rn.cliente.Cliente;
import com.acme.rn.cliente.Cpf;
import com.acme.rn.conta.ContaMilhagem;
import com.acme.rn.conta.IdentificadorConta;

public class IOConta implements InterfaceRepositorioContaMilhagem {
	IORepositorios<ContaMilhagem> io = new IORepositorios<ContaMilhagem>();
	FileWriter file;
	FileReader file2;
	File file3 = new File("Conta/");
	BufferedReader ler;
	BufferedWriter escrever;

	@Override
	public ContaMilhagem buscar(IdentificadorConta c1)
			throws AtributoInvalidoException {
		return (ContaMilhagem) io.buscar(c1.toString(), false);
	}

	@Override
	public ContaMilhagem buscarpeloCpf(String cpf)
			throws AtributoInvalidoException, ObjetoNaoExistenteException {
		return (ContaMilhagem) io.buscar(cpf, false);
	}

	@Override
	public void incluir(ContaMilhagem cm) throws AtributoInvalidoException,
			ObjetoExistenteException {
		try {
			io.incluir(cm);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void alterar(IdentificadorConta existente, ContaMilhagem cm)
			throws AtributoInvalidoException, ObjetoNaoExistenteException {
		try {
			io.alterar(String.valueOf(existente.getNumero()), cm, false);
		} catch (ObjetoExistenteException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void excluir(ContaMilhagem cm) throws AtributoInvalidoException,
			ObjetoNaoExistenteException {
		io.excluir(cm.getChave(), false);

	}

	@Override
	public ContaMilhagem[] listar() throws AtributoInvalidoException {
		File[] f = file3.listFiles();
		String[] linha = new String[6];
		ContaMilhagem[] c = new ContaMilhagem[f.length];

		for (int i = 0; i < f.length; i++) {

			try {

				file2 = new FileReader(f[i]);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			ler = new BufferedReader(file2);

			for (int j = 0; j < 6; j++) {
				try {
					linha[j] = ler.readLine();

				} catch (IOException e) { // TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				ler.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			Cpf CPF = new Cpf(linha[1]);
			Cliente nvCLiente = new Cliente(CPF, linha[2],
					Integer.parseInt(linha[3]), Double.parseDouble(linha[5]),
					Integer.parseInt(linha[4]));
			IdentificadorConta id = new IdentificadorConta(
					Long.parseLong(linha[1]));
			ContaMilhagem nvConta = new ContaMilhagem(id, nvCLiente);
			nvConta.setSaldo(Integer.parseInt(linha[0]));
			c[i] = nvConta;
		}

		return c;

	}

}
