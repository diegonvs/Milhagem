package com.acme.ado.classesGerais;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.acme.excecoes.AtributoInvalidoException;
import com.acme.excecoes.ObjetoExistenteException;
import com.acme.excecoes.ObjetoNaoExistenteException;
import com.acme.rn.classesGerais.Registro;
import com.acme.rn.cliente.Cliente;
import com.acme.rn.cliente.Cpf;
import com.acme.rn.conta.ContaMilhagem;
import com.acme.rn.conta.IdentificadorConta;
import com.acme.rn.conta.MovimentoConta;

public class IORepositorios<T> {

	FileWriter file;
	FileReader file2;
	BufferedReader ler;
	BufferedWriter escrever;
	File file3 = new File("Cliente/");
	File file4 = new File("Conta/");

	String barra = System.getProperty("File.separator");
	public final String CAMINHO = "./Milhagem" + barra + "Smiles";

	public <T> void incluir(T id) throws AtributoInvalidoException,
			ObjetoExistenteException, IOException {
		Cliente c;
		ContaMilhagem cm;
		MovimentoConta mc;
		if (id.equals(null)) {
			throw new AtributoInvalidoException(
					"Id nulo!");
		} else {
			if (id instanceof Cliente ) {
				c = (Cliente) id;
				if(buscar(c.getChave(), true) == null){
					file = new FileWriter(new File("Cliente/" + c.getChave()
							+ ".txt"));
					escrever = new BufferedWriter(file);
					escrever.write(c.getNome());
					escrever.newLine();
					escrever.write(String.valueOf(c.getCpf().getCpf()));
					escrever.newLine();
					escrever.write(String.valueOf(c.getIdade()));
					escrever.newLine();
					escrever.write(String.valueOf(c.getSexo()));
					escrever.newLine();
					escrever.write(String.valueOf(c.getRenda()));
					escrever.close();
				}else{
					throw new ObjetoExistenteException("Cliente existente!");
				}
			}
			if (id instanceof ContaMilhagem) {
				cm = (ContaMilhagem) id;
				if(buscar(cm.getChave(), false) == null){
					file = new FileWriter(new File("Conta/" + cm.getChave()
							+ ".txt"));
					escrever = new BufferedWriter(file);
					escrever.write(String.valueOf(cm.getSaldo()));
					escrever.newLine();
					escrever.write(String.valueOf(cm.getChave()));
					escrever.newLine();
					escrever.write(String.valueOf(cm.getCliente().getNome()));
					escrever.newLine();
					escrever.write(String.valueOf(cm.getCliente().getIdade()));
					escrever.newLine();
					escrever.write(String.valueOf(cm.getCliente().getSexo()));
					escrever.newLine();
					escrever.write(String.valueOf(cm.getCliente().getRenda()));
					escrever.close();
				}
				
			}

			if (id instanceof MovimentoConta) {
				mc = (MovimentoConta) id;
				if(buscar(mc.getChave(), true) == null){
					file = new FileWriter(new File("Movimento/" + mc.getChave()
							+ ".txt"));
					escrever = new BufferedWriter(file);
					escrever.write(mc.toString());
					escrever.newLine();
					escrever.close();
				}
			}
		}
	}

	public <T> void alterar(String chave, T obj, boolean p)
			throws AtributoInvalidoException, ObjetoExistenteException, IOException {

		if (buscar(chave, p) != null && obj != null) {
			String a = chave + ".txt";
			File[] f = file3.listFiles();
			File[] f2 = file4.listFiles();
			for (int i = 0; i < f2.length; i++) {
				if (buscar(chave, p) instanceof ContaMilhagem
						&& a.equals(f2[i].getName())) {
					((ContaMilhagem) obj).setSaldo(((ContaMilhagem) buscar(
							chave, p)).getSaldo());
					excluir(chave, p);
					try {
						ContaMilhagem cm2 =(ContaMilhagem) obj;
						incluir(cm2);
						
					} catch (AtributoInvalidoException e) {
						System.out.println(e.getMessage());
					}

				}
			}

			for (int i = 0; i < f.length; i++) {
				if (buscar(chave, p) instanceof Cliente
						&& a.equals(f[i].getName())) {
					try {
						excluir(chave, p);
						incluir((Cliente) obj);
					} catch (AtributoInvalidoException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		} else {
			throw new AtributoInvalidoException("Cliente inexistente!");
		}
	}

	public <T> void excluir(String chave, boolean p) //p = true irá ser cliente, p = false irá ser contamilhagem,xero
			throws AtributoInvalidoException {

		if (buscar(chave, p) != null) {
			String a = chave + ".txt";
			File[] f = file3.listFiles();
			File[] f2 = file4.listFiles();
			for (int i = 0; i < f.length; i++)
				if (buscar(chave, p) instanceof Cliente
						&& a.equals(f[i].getName()))
					f[i].delete();

			for (int i = 0; i < f2.length; i++)
				if (buscar(chave, p) instanceof ContaMilhagem
						&& a.equals(f2[i].getName()))
					f2[i].delete();

		} else
			throw new AtributoInvalidoException("Cliente inexistente!");
	}

	public <T> Registro buscar(String chave, boolean p) {

		File[] f;
		if (p)
			f = file3.listFiles();
		else
			f = file4.listFiles();
		String a = chave + ".txt";
		String[] linha = new String[6];
		Cliente nvCLiente;

		for (int i = 0; i < f.length; i++) {

			if (a.equals(f[i].getName())) {

				try {
					file2 = new FileReader(f[i]);
					ler = new BufferedReader(file2);
					for (int j = 0; j < 6; j++) {

						linha[j] = ler.readLine();

					}
					ler.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				if (p == true) {
					Cpf cpf = new Cpf(linha[1]);
					nvCLiente = new Cliente(cpf, linha[0],
							Integer.parseInt(linha[2]),
							Float.parseFloat(linha[4]),
							Integer.parseInt(linha[3]));
					return nvCLiente;
				} else {
					Cpf cpf = new Cpf(linha[1]);
					nvCLiente = new Cliente(cpf, linha[2],
							Integer.parseInt(linha[3]),
							Float.parseFloat(linha[5]),
							Integer.parseInt(linha[4]));
					IdentificadorConta id = new IdentificadorConta(
							Long.parseLong(linha[1]));
					ContaMilhagem nvConta = new ContaMilhagem(id, nvCLiente);
					nvConta.setSaldo(Integer.parseInt(linha[0]));
					return nvConta;
				}

			}

		}

		return null;

	}

}
