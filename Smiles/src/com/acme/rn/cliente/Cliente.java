package com.acme.rn.cliente;

import java.util.Scanner;

import com.acme.excecoes.AtributoInvalidoException;
import com.acme.rn.classesGerais.Registro;

public class Cliente extends Registro {
	// Atributos
	private Cpf cpf;
	private String nome;
	private int idade;
	private int sexo;
	public static final int SEXO_MASC = 0;
	public static final int SEXO_FEM = 1;
	private double renda;

	// Getters and Setters:
	public Cpf getCpf() {
		return cpf;
	}

	public void setCpf(Cpf cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public double getRenda() {
		return renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}

	// Métodos
	// Método para converter para string os valores atribuídos a nome e a cpf
	// da classe
	public String toString() {
		String r = "Nome: " + this.nome + "\n" + "Idade: " + this.idade + "\n"
				+ "Renda: " + this.renda + "\n";
		return r;
	}

	// Método que retorna o primeiro nome do atributo nome da classe
	public String getPrimeiroNome() {
		String primeiroNome = "";
		String nome = this.nome;
		for (int i = 0; i < nome.length(); i++) {
			if ((i == 0) && (nome.substring(i, i + 1).equalsIgnoreCase(" "))) {
				System.out
						.println("Erro: Nome digitado iniciado com tecla ESPAÃ‡O.");
				break;
			} else if (!nome.substring(i, i + 1).equalsIgnoreCase(" ")) {
				primeiroNome += nome.substring(i, i + 1);
			} else
				break;
		}
		return primeiroNome;
	}

	// Método que retorna o primeiro nome do atributo nome da classe
	public String getUltimoNome() {
		String nome = this.nome;
		String ultimoNome = "";
		for (int w = nome.length(); w > 0; w--) {
			if (w != nome.lastIndexOf(' ')) {
				ultimoNome = nome.substring(w, nome.length());
			} else {
				break;
			}
		}
		return ultimoNome;
	}

	public static Cliente criarObjeto(Scanner s) {
		String nome;
		int idade, sexo;
		double renda;
		System.out.println("Informe o nome do cliente: ");
		nome = s.nextLine();
		System.out.println("Informe a idade do cliente: ");
		idade = s.nextInt();
		System.out.println("Informe a renda do cliente: ");
		renda = s.nextDouble();
		System.out
				.println("Informe o sexo do cliente[0 para Masculino,1 para Feminino]: ");
		sexo = s.nextInt();
		Cpf cpf = Cpf.criarObjeto(s);
		Cliente c = new Cliente(cpf.toString(), nome, idade, renda, sexo);
		return c;
	}

	public String getChave() {
		return this.cpf.getCpf();
	}

	// Construtor com atributo cpf do tipo inteiro
	public Cliente(int numero, int dig, String nome, int idade, double renda,
			int sexo) {
		this.cpf.setDigito(dig);
		this.cpf.setNumero(numero);
		this.setNome(nome);
		this.setIdade(idade);
		this.setRenda(renda);
		this.setSexo(sexo);
	}

	// Construtor com atributo cpf do tipo string
	public Cliente(String cpf, String nome, int idade, double renda, int sexo) {
		try {
			this.validar();
		} catch (AtributoInvalidoException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		try {
			this.validar();
		} catch (AtributoInvalidoException e) {
			System.out.println(e.getMessage());
		}
		this.cpf.setCpf(cpf);
		this.setNome(nome);
		this.setIdade(idade);
		this.setRenda(renda);
		this.setSexo(sexo);
	}

	@Override
	public void validar() throws AtributoInvalidoException {
		// TODO Auto-generated method stub
		if (this.cpf.equals(null)) {
			throw new AtributoInvalidoException("Cpf não pode ser nulo!");
		}
		if (this.nome.equals(null) || this.nome.length() == 60
				|| this.nome.equals(" ")) {
			throw new AtributoInvalidoException(
					"Nome não pode ser null ou ter mais que 60 caracteres");
		}
		if (this.idade < 18 || this.idade > 200) {
			throw new AtributoInvalidoException(
					"Idade não pode ser menor que 18 ou maior que 200");
		}
		if (this.renda < 0 || this.renda > 1000000) {
			throw new AtributoInvalidoException(
					"Renda não pode ser negativa ou maior que um milhão.");
		}
		if (!(this.sexo == 1 || this.sexo == 0)) {
			throw new AtributoInvalidoException(
					"Sexo só pode ter valor de 0[Masculino] e 1[Feminino]");
		}
	}

}