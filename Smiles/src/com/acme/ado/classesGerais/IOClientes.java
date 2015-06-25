package com.acme.ado.classesGerais;

import com.acme.excecoes.AtributoInvalidoException;
import com.acme.excecoes.ObjetoExistenteException;
import com.acme.excecoes.ObjetoNaoExistenteException;
import com.acme.rn.cliente.Cliente;
import com.acme.rn.cliente.Cpf;

import java.io.*;

public class IOClientes implements InterfaceRepositorioClientes {
	IORepositorios<Cliente> ioCliente = new IORepositorios<Cliente>();
	public IOConta ioConta = new IOConta();
	FileWriter file;
	FileReader file2;
	BufferedReader ler;
	BufferedWriter escrever;
	File file3 = new File("Cliente/");

	@Override
	public Cliente buscarporChave(String chave)
			throws AtributoInvalidoException {
		return (Cliente) ioCliente.buscar(chave, true);
	}

	@Override
	public void incluir(Cliente c) throws AtributoInvalidoException,
			ObjetoExistenteException {
		try {
			ioCliente.incluir(c);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void alterar(Cliente novo, Cliente existente)
			throws AtributoInvalidoException, ObjetoNaoExistenteException,
			ObjetoExistenteException, IOException {
		ioCliente.alterar(existente.getCpf().getCpf(), novo, true);

	}

	public void excluir(Cpf cpf) throws AtributoInvalidoException,
			ObjetoNaoExistenteException {
		ioCliente.excluir(cpf.getCpf(), true);
	}

	@Override
	public Cliente[] buscaTodos() {
		File[] f = file3.listFiles();
		Cliente[] c = new Cliente[f.length];

		Cliente nvCLiente = null;
		String[] linha = new String[5];
		for (int i = 0; i < f.length; i++) {
			linha = new String[5];

			try {
				file2 = new FileReader(f[i]);

			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}

			ler = new BufferedReader(file2);

			for (int j = 0; j < 5; j++) {
				try {
					linha[j] = ler.readLine();
				} catch (IOException e) { // TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
			try {
				ler.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			Cpf CPF = new Cpf(linha[1]);
			nvCLiente = new Cliente(CPF, linha[0], Integer.parseInt(linha[2]),
					Float.parseFloat(linha[4]), Integer.parseInt(linha[3]));
			c[i] = nvCLiente;

		}
		return c;
	}

}
