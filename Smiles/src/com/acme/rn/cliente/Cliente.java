package com.acme.rn.cliente;

import java.util.Scanner;

public class Cliente extends Cpf {
	Cpf cpf;
	private String nome;
	private int idade;
	private int sexo;
	public static final int SEXO_MASC = 0;
	public static final int SEXO_FEM = 1;
	private double renda;

	// Método para converter para string os valores atribuidos a nome e a cpf da classe
	public String toString() {
		String r = "Nome: " + this.nome + "\n" + "Idade: " + this.idade + "\n" + "Renda: " + this.renda
				+ "\n";
		return r;
	}

	// Método que retorna o primeiro nome do atributo nome da classe
	public String getPrimeiroNome() {
		String primeiroNome = "";
		String nome = this.nome;
		for (int i = 0; i < nome.length(); i++) {
			if ((i == 0) && (nome.substring(i, i + 1).equalsIgnoreCase(" "))) {
				System.out
						.println("Erro: Nome digitado iniciado com tecla ESPAÇO.");
				break;
			} else if (!nome.substring(i, i + 1).equalsIgnoreCase(" ")) {
				primeiroNome += nome.substring(i, i + 1);
			} else
				break;
		}
		return primeiroNome;
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
		int idade,sexo;
		double renda;
		System.out.println("Informe o nome do cliente: ");
		nome = s.nextLine();
		System.out.println("Informe a idade do cliente: ");
		idade = s.nextInt();
		System.out.println("Informe a renda do cliente: ");
		renda = s.nextDouble();
		System.out.println("Informe o sexo do cliente[0 para Masculino,1 para Feminino]: ");
		sexo = s.nextInt();
		Cpf cpf = Cpf.criarObjeto(s);
		Cliente c = new Cliente(cpf.toString(), nome, idade,renda,sexo);
		return c;
	}
	
	// Construtor com atributo cpf do tipo inteiro
	public Cliente(int numero, int dig, String nome, int idade, double renda,
			int sexo) {
		super(numero, dig);
		this.setNome(nome);
		this.setIdade(idade);
		this.setRenda(renda);
		this.setSexo(sexo);
	}

	// Construtor com atributo cpf do tipo string
	public Cliente(String cpf, String nome, int idade, double renda, int sexo) {
		super(cpf);
		this.setNome(nome);
		this.setIdade(idade);
		this.setRenda(renda);
		this.setSexo(sexo);
	}
}