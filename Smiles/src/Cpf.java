import java.util.Scanner;

public class Cpf {

	private int numero;
	private int digito;

	public Cpf(int numero, int digito) {
		this.setNumero(numero);
		this.setDigito(digito);
		// if (this.verificaCPF() == false)
		// System.err.println("CPF invalido!");
	}

	/*private boolean verificaCPF() {
		// TODO Auto-generated method stub
		return false;
	}*/

	public Cpf(String cpf) {
		// TODO - implementar a convers�o da String para numero e digito
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		if (numero > 0 && numero <= 999999999) {
			this.numero = numero;
		} else {
			System.err.println("Numero do cpf invalido!");
		}
	}

	public int getDigito() {
		return digito;
	}

	public void setDigito(int digito) {
		if (digito >= 0 && digito <= 99) {
			this.digito = digito;
		} else {
			System.err.println("Digito do cpf invalido!");
		}
	}

	public String getCpf() {
		String resultado = String.format("%09d-%02d", numero, digito);
		return resultado;
	}

	public boolean equals(Cpf cpf) {
		return this.numero == cpf.numero && this.digito == cpf.digito;
	}

	public String toString() {
		return "CPF: " + this.getCpf();
	}

	public static Cpf criarObjeto(Scanner s) {
		int num, dig;
		System.out.print("Informe o numero do CPF: ");
		num = s.nextInt();
		s.nextLine();
		System.out.print("Informe o digito verificador do CPF: ");
		dig = s.nextInt();
		s.nextLine();
		Cpf c = new Cpf(num, dig);
		return c;
	}
}
