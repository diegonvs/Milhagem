public class Cliente extends Cpf {
	Cpf cpf;
	String nome;
	int idade, sexo; // 0 para masculino e 1 para feminino
	double renda;

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

	// Construtor com atributo cpf do tipo inteiro
	public Cliente(int numero, int dig, String nome, int idade, double renda,
			int sexo) {
		super(numero, dig);
		this.nome = nome;
		this.idade = idade;
		this.renda = renda;
		this.sexo = sexo;
	}

	// Construtor com atributo cpf do tipo string
	public Cliente(String cpf, String nome, int idade, double renda, int sexo) {
		super(cpf);
		this.nome = nome;
		this.idade = idade;
		this.renda = renda;
		this.sexo = sexo;
	}
}