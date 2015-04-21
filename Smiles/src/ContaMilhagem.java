public class ContaMilhagem {
	IdentificadorConta identificadorconta;
	Cliente cliente;
	int saldo;
	boolean ativa;

	public void Creditar(int valor) {
		this.saldo = valor + saldo;
	}

	public void Debitar(int valor) {
		if (saldo > valor) {
			this.saldo = saldo - valor;
		} else {
			System.out.println("Saldo insuficiente!");
		}
	}

	public void Transferir(int valor, ContaMilhagem c) {
		this.Debitar(valor);
		c.Creditar(valor);
	}

	public void Desativar() {
		this.ativa = false;
	}

	public void Reativar() {
		this.ativa = true;
	}

	public String toString() {
		String s = this.identificadorconta.toString();
		return s;
	}

	public ContaMilhagem(IdentificadorConta identificadorconta, Cliente cliente) {
		this.identificadorconta = identificadorconta;
		this.cliente = cliente;
		this.saldo = 0;
		this.ativa = true;
	}
}
