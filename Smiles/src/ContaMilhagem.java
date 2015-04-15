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
			this.saldo = valor - saldo;
		} else {
			System.out.println("Saldo insuficiente!");
		}
	}

	public void Transferir(int valor, ContaMilhagem c) {
		this.Debitar(valor);
		c.Creditar(valor);
	}

	public void Desativar() {
		ativa = false;
	}

	public void Reativar() {
		ativa = true;
	}
/*Construtor: Um construtor que receba os valores do identificador de conta
(este argumento deve ser do tipo do atributo identificador de conta) e do
cliente (que deve ser do tipo do atributo cliente). Com estes valores, inicializar
os atributos correspondentes. Inicializar o saldo com zero e o atributo ativa
com verdadeiro.*/
	public ContaMilhagem(IdentificadorConta identificadorconta,Cliente cliente) {
		this.identificadorconta = identificadorconta;
		this.cliente = cliente;
		this.saldo = 0;
		this.ativa = true;
	}
}
